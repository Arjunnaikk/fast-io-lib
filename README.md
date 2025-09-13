# Fast IO Library

A high-performance Java library for fast input/output operations, optimized for competitive programming and applications requiring efficient I/O.

## Features

- **FastReader**: Optimized input reading with BufferedReader and StringTokenizer
- **FastWriter**: Optimized output writing with BufferedWriter
- Support for all common data types (int, long, double, float, char, String)
- Array reading/writing utilities
- Multiple input sources (System.in, InputStream, File)
- AutoCloseable support for proper resource management

## Installation

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

## Usage

```java
import io.github.arjunnaikk.io.FastReader;
import io.github.arjunnaikk.io.FastWriter;

try (FastReader reader = new FastReader();
     FastWriter writer = new FastWriter()) {
    
    int n = reader.nextInt();
    int[] arr = reader.nextIntArray(n);
    
    writer.println("Array contents:");
    writer.printArray(arr);
    writer.flush();
    
} catch (IOException e) {
    e.printStackTrace();
}
```

## Performance

FastReader is significantly faster than Scanner for competitive programming scenarios, especially when reading large amounts of data.

## License

MIT License - see LICENSE file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.