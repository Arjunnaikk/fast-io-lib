package io.github.arjunnaikk.io;

import java.io.*;
import java.util.StringTokenizer;

/**
 * FastReader provides optimized input reading capabilities for competitive programming
 * and high-performance applications. It offers faster alternatives to Scanner and
 * BufferedReader for common input operations.
 * 
 * @author Arjunnaikk
 * @version 1.0.0
 */
public class FastReader implements AutoCloseable {
    private BufferedReader br;
    private StringTokenizer st;

    /**
     * Creates a new FastReader that reads from System.in
     */
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Creates a new FastReader that reads from the specified InputStream
     * 
     * @param inputStream the input stream to read from
     */
    public FastReader(InputStream inputStream) {
        br = new BufferedReader(new InputStreamReader(inputStream));
    }

    /**
     * Creates a new FastReader that reads from the specified file
     * 
     * @param fileName the name of the file to read from
     * @throws FileNotFoundException if the file is not found
     */
    public FastReader(String fileName) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(fileName));
    }

    /**
     * Reads the next token (word) from the input
     * 
     * @return the next token as a string
     * @throws IOException if an I/O error occurs
     */
    public String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    /**
     * Reads the next line from the input
     * 
     * @return the next line as a string
     * @throws IOException if an I/O error occurs
     */
    public String nextLine() throws IOException {
        return br.readLine();
    }

    /**
     * Reads the next integer from the input
     * 
     * @return the next integer
     * @throws IOException if an I/O error occurs
     * @throws NumberFormatException if the next token is not a valid integer
     */
    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    /**
     * Reads the next long from the input
     * 
     * @return the next long
     * @throws IOException if an I/O error occurs
     * @throws NumberFormatException if the next token is not a valid long
     */
    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    /**
     * Reads the next double from the input
     * 
     * @return the next double
     * @throws IOException if an I/O error occurs
     * @throws NumberFormatException if the next token is not a valid double
     */
    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    /**
     * Reads the next float from the input
     * 
     * @return the next float
     * @throws IOException if an I/O error occurs
     * @throws NumberFormatException if the next token is not a valid float
     */
    public float nextFloat() throws IOException {
        return Float.parseFloat(next());
    }

    /**
     * Reads the next character from the input
     * 
     * @return the next character
     * @throws IOException if an I/O error occurs
     */
    public char nextChar() throws IOException {
        return next().charAt(0);
    }

    /**
     * Reads an array of integers
     * 
     * @param n the number of integers to read
     * @return an array containing the read integers
     * @throws IOException if an I/O error occurs
     */
    public int[] nextIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }

    /**
     * Reads an array of longs
     * 
     * @param n the number of longs to read
     * @return an array containing the read longs
     * @throws IOException if an I/O error occurs
     */
    public long[] nextLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        return arr;
    }

    /**
     * Closes the underlying BufferedReader
     * 
     * @throws IOException if an I/O error occurs
     */
    public void close() throws IOException {
        if (br != null) {
            br.close();
        }
    }
}