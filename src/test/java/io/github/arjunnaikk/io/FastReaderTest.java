package io.github.arjunnaikk.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

/**
 * Unit tests for FastReader class
 * 
 * @author Arjunnaikk
 * @version 1.0.0
 */
public class FastReaderTest {
    
    private FastReader reader;
    private ByteArrayInputStream testInput;
    
    /**
     * Sets up test fixtures before each test method
     */
    @BeforeEach
    public void setUp() {
        // This will be initialized in individual test methods with specific input
    }
    
    /**
     * Cleans up after each test method
     */
    @AfterEach
    public void tearDown() throws IOException {
        if (reader != null) {
            reader.close();
        }
        if (testInput != null) {
            testInput.close();
        }
    }
    
    /**
     * Helper method to create a FastReader with test input
     */
    private void setupReaderWithInput(String input) {
        testInput = new ByteArrayInputStream(input.getBytes());
        reader = new FastReader(testInput);
    }
    
    @Test
    public void testNextInt() throws IOException {
        setupReaderWithInput("42 -17 0 2147483647");
        
        assertEquals(42, reader.nextInt());
        assertEquals(-17, reader.nextInt());
        assertEquals(0, reader.nextInt());
        assertEquals(2147483647, reader.nextInt());
    }
    
    @Test
    public void testNextLong() throws IOException {
        setupReaderWithInput("9223372036854775807 -9223372036854775808 0");
        
        assertEquals(9223372036854775807L, reader.nextLong());
        assertEquals(-9223372036854775808L, reader.nextLong());
        assertEquals(0L, reader.nextLong());
    }
    
    @Test
    public void testNextDouble() throws IOException {
        setupReaderWithInput("3.14159 -2.71828 0.0");
        
        assertEquals(3.14159, reader.nextDouble(), 0.00001);
        assertEquals(-2.71828, reader.nextDouble(), 0.00001);
        assertEquals(0.0, reader.nextDouble(), 0.00001);
    }
    
    @Test
    public void testNextFloat() throws IOException {
        setupReaderWithInput("3.14 -2.71 0.0");
        
        assertEquals(3.14f, reader.nextFloat(), 0.001f);
        assertEquals(-2.71f, reader.nextFloat(), 0.001f);
        assertEquals(0.0f, reader.nextFloat(), 0.001f);
    }
    
    @Test
    public void testNext() throws IOException {
        setupReaderWithInput("hello world java programming");
        
        assertEquals("hello", reader.next());
        assertEquals("world", reader.next());
        assertEquals("java", reader.next());
        assertEquals("programming", reader.next());
    }
    
    @Test
    public void testNextLine() throws IOException {
        setupReaderWithInput("First line\nSecond line\nThird line");
        
        assertEquals("First line", reader.nextLine());
        assertEquals("Second line", reader.nextLine());
        assertEquals("Third line", reader.nextLine());
    }
    
    @Test
    public void testNextChar() throws IOException {
        setupReaderWithInput("a b c d");
        
        assertEquals('a', reader.nextChar());
        assertEquals('b', reader.nextChar());
        assertEquals('c', reader.nextChar());
        assertEquals('d', reader.nextChar());
    }
    
    @Test
    public void testNextIntArray() throws IOException {
        setupReaderWithInput("1 2 3 4 5");
        
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = reader.nextIntArray(5);
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testNextLongArray() throws IOException {
        setupReaderWithInput("1000000000000 2000000000000 3000000000000");
        
        long[] expected = {1000000000000L, 2000000000000L, 3000000000000L};
        long[] actual = reader.nextLongArray(3);
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testMixedInput() throws IOException {
        setupReaderWithInput("5\n1 2 3 4 5\nhello world\n3.14 2.71");
        
        int n = reader.nextInt();
        assertEquals(5, n);
        
        int[] arr = reader.nextIntArray(n);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
        
        String str1 = reader.next();
        String str2 = reader.next();
        assertEquals("hello", str1);
        assertEquals("world", str2);
        
        double d1 = reader.nextDouble();
        double d2 = reader.nextDouble();
        assertEquals(3.14, d1, 0.001);
        assertEquals(2.71, d2, 0.001);
    }
    
    @Test
    public void testNumberFormatException() {
        setupReaderWithInput("not_a_number");
        
        assertThrows(NumberFormatException.class, () -> {
            reader.nextInt();
        });
    }
    
    @Test
    public void testEmptyArray() throws IOException {
        setupReaderWithInput("");
        
        int[] result = reader.nextIntArray(0);
        assertEquals(0, result.length);
    }
}