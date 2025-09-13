# Fast IO Library

A high-performance Java library for fast input/output operations, optimized for competitive programming and applications requiring efficient I/O.

## Features

  * **FastReader**: Optimized input reading with `BufferedReader` and `StringTokenizer`.
  * **FastWriter**: Optimized output writing with `BufferedWriter`.
  * Support for all common data types (int, long, double, float, char, String).
  * Utilities for reading and writing entire arrays.
  * Support for multiple input sources (`System.in`, `InputStream`, `File`).
  * `AutoCloseable` support for easy use in try-with-resources blocks.

-----

## Why is this faster than Scanner?

Standard `java.util.Scanner` is slow because it uses regular expressions (regex) to parse every token. This adds a significant amount of computational overhead, which can cause a "Time Limit Exceeded" (TLE) verdict in competitive programming.

This library avoids regex entirely. It works by:

1.  **Buffering:** Using `BufferedReader` to read a large chunk of data from the input stream into memory at once.
2.  **Tokenizing:** Using the much simpler and faster `StringTokenizer` to rapidly split the in-memory line by spaces.

### Performance Benchmark

This simple test read 10 million integers from a text file.

| Method | Time |
| :--- | :--- |
| `java.util.Scanner` | \~2.54 seconds |
| **FastReader (This Lib)** | **\~0.81 seconds** |

-----

## Installation (For Local Projects)

Use these instructions if you are building a Java project on your own computer with Maven or Gradle. **Note:** This will *not* work for competitive programming submissions (see the next section).

### Maven

```xml
<dependency>
    <groupId>io.github.arjunnaikk</groupId>
    <artifactId>fast-io-lib</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```gradle
implementation 'io.github.arjunnaikk:fast-io-lib:1.0.0'
```

-----

## Usage

### 1\. Local Project (with Maven/Gradle)

This is the standard use case for a local project. Simply add the dependency and import the classes.

```java
import io.github.arjunnaikk.io.FastReader;
import io.github.arjunnaikk.io.FastWriter;
import java.io.IOException;

public class MyProject {
    public static void main(String[] args) {
        try (FastReader reader = new FastReader();
             FastWriter writer = new FastWriter()) {
            
            int n = reader.nextInt();
            int[] arr = reader.nextIntArray(n);
            
            writer.println("Array contents:");
            writer.printArray(arr);
            writer.flush(); // Always flush the writer
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 2\. Competitive Programming (Online Judges)

**You cannot use the Maven/Gradle dependency on sites like Codeforces, LeetCode, or AtCoder.** Their systems will not download the library, and your `import` will cause a Compilation Error.

For these sites, you must **copy the raw source code** of the library and paste it directly into your submission file.

**Submission Template:**

1.  Create your main solution file (e.g., `Main.java`).
2.  Copy the raw code from these two files:
      * [**FastReader.java (Source)**](https://www.google.com/search?q=https://github.com/Arjunnaikk/fast-io-lib/blob/main/src/main/java/io/github/arjunnaikk/io/FastReader.java)
      * [**FastWriter.java (Source)**](https://www.google.com/search?q=https://github.com/Arjunnaikk/fast-io-lib/blob/main/src/main/java/io/github/arjunnaikk/io/FastWriter.java)
3.  Paste both full classes *below* your main solution class (all in the same `.java` file).
4.  **CRITICAL STEP:** Remove the `public` keyword from the `FastReader` and `FastWriter` class declarations (e.g., change `public class FastReader` to just `class FastReader`). A single file can only have one `public` class.

Your final submission file should look like this:

```java
// Import all necessary Java standard libraries
import java.io.*;
import java.util.StringTokenizer;
// ... add any other java.util.* imports you need for your solution

/**
 * STEP 1: This is your main solution class.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // You can now create instances of FastReader/Writer,
        // because their code is in the same file!
        try (FastReader reader = new FastReader();
             FastWriter writer = new FastWriter()) {

            // --- YOUR SOLUTION LOGIC GOES HERE ---
            int n = reader.nextInt();
            int[] arr = reader.nextIntArray(n);
            
            writer.printArray(arr);
            writer.flush();
            // -------------------------------------
        }
    }
}

// ---------------------------------------------------------------
// TEMPLATE CODE - PASTE LIBRARY SOURCE BELOW
// ---------------------------------------------------------------

/**
 * STEP 2: Paste the FastReader class code here.
 * NOTICE: The 'public' keyword has been REMOVED.
 */
class FastReader implements AutoCloseable {
    private BufferedReader br;
    private StringTokenizer st;

    // ... (full source code of FastReader.java goes here) ...
}

/**
 * STEP 3: Paste the FastWriter class code here.
 * NOTICE: The 'public' keyword has also been REMOVED.
 */
class FastWriter implements AutoCloseable {
    private BufferedWriter bw;

    // ... (full source code of FastWriter.java goes here) ...
}
```

-----

## Advanced Usage & API

### Reading from a File

The library isn't just for console input. It's highly effective for parsing large, space-delimited text files. Just pass any `InputStream` (like a `FileInputStream`) to the constructor.

```java
import io.github.arjunnaikk.io.FastReader;
import java.io.FileInputStream;
import java.io.IOException;

// ...

try (FastReader reader = new FastReader(new FileInputStream("my_large_data_file.txt"))) {
    
    // Read the first number from the file
    int totalEntries = reader.nextInt();
    
    // ... process the rest of the file ...
    
} catch (IOException e) {
    e.printStackTrace();
}
```

### Available Methods (API)

**FastReader:**

  * `String next()`
  * `int nextInt()`
  * `long nextLong()`
  * `double nextDouble()`
  * `String nextLine()`
  * `int[] nextIntArray(int n)`
  * `long[] nextLongArray(int n)`
  * `double[] nextDoubleArray(int n)`
  * `void close()`

**FastWriter:**

  * `void print(Object... objects)`
  * `void println(Object... objects)`
  * `void printArray(int[] arr)`
  * `void printArray(long[] arr)`
  * `void printArray(double[] arr)`
  * `void flush()`
  * `void close()`

-----

## License

MIT License - see LICENSE file for details.

## Contributing

Contributions are welcome\! Please feel free to submit a Pull Request.
