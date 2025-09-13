# 🚀 Deployment Guide for Fast-IO Library

## Quick Start for Users

### Option 1: JitPack (Recommended - No setup required)

Add this to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.arjunnaikk</groupId>
    <artifactId>fast-io-lib</artifactId>
    <version>v1.0.0</version>
</dependency>
```

### Option 2: Download JAR directly

1. Go to [Releases](https://github.com/arjunnaikk/fast-io-lib/releases)
2. Download `fast-io-lib-1.0.0.jar`
3. Add to your project classpath

### Option 3: Maven Central (Once published)

```xml
<dependency>
    <groupId>io.github.arjunnaikk</groupId>
    <artifactId>fast-io-lib</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage Example

```java
import io.github.arjunnaikk.io.FastReader;
import io.github.arjunnaikk.io.FastWriter;

public class Example {
    public static void main(String[] args) {
        try (FastReader reader = new FastReader();
             FastWriter writer = new FastWriter()) {
            
            int n = reader.nextInt();
            int[] arr = reader.nextIntArray(n);
            
            writer.println("Sum: " + Arrays.stream(arr).sum());
            writer.printArray(arr);
            writer.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Publishing Steps (For Library Author)

### 1. JitPack Deployment
```bash
# Just push to GitHub - JitPack builds automatically
git add .
git commit -m "Release v1.0.0"
git tag v1.0.0
git push origin main --tags
```

### 2. Maven Central Deployment
```bash
# After setting up Sonatype account and GPG keys
mvn clean deploy
```

### 3. GitHub Packages
```bash
# After configuring GitHub token
mvn deploy
```

## Build Commands

```bash
# Build JAR
mvn package

# Run tests
mvn test

# Generate sources and javadoc JARs
mvn package -P release

# Clean build
mvn clean compile
```