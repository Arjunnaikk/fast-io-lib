package io.github.arjunnaikk.io;

import java.io.*;

/**
 * FastWriter provides optimized output writing capabilities for competitive programming
 * and high-performance applications. It offers faster alternatives to PrintWriter and
 * System.out for common output operations.
 * 
 * @author Arjunnaikk
 * @version 1.0.0
 */
public class FastWriter implements AutoCloseable {
    private PrintWriter pw;

    /**
     * Creates a new FastWriter that writes to System.out
     */
    public FastWriter() {
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    /**
     * Creates a new FastWriter that writes to the specified OutputStream
     * 
     * @param outputStream the output stream to write to
     */
    public FastWriter(OutputStream outputStream) {
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    /**
     * Creates a new FastWriter that writes to the specified file
     * 
     * @param fileName the name of the file to write to
     * @throws IOException if the file cannot be created
     */
    public FastWriter(String fileName) throws IOException {
        pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
    }

    /**
     * Prints an object
     * 
     * @param obj the object to print
     */
    public void print(Object obj) {
        pw.print(obj);
    }

    /**
     * Prints a string
     * 
     * @param str the string to print
     */
    public void print(String str) {
        pw.print(str);
    }

    /**
     * Prints an integer
     * 
     * @param i the integer to print
     */
    public void print(int i) {
        pw.print(i);
    }

    /**
     * Prints a long
     * 
     * @param l the long to print
     */
    public void print(long l) {
        pw.print(l);
    }

    /**
     * Prints a double
     * 
     * @param d the double to print
     */
    public void print(double d) {
        pw.print(d);
    }

    /**
     * Prints a character
     * 
     * @param c the character to print
     */
    public void print(char c) {
        pw.print(c);
    }

    /**
     * Prints an object followed by a newline
     * 
     * @param obj the object to print
     */
    public void println(Object obj) {
        pw.println(obj);
    }

    /**
     * Prints a string followed by a newline
     * 
     * @param str the string to print
     */
    public void println(String str) {
        pw.println(str);
    }

    /**
     * Prints an integer followed by a newline
     * 
     * @param i the integer to print
     */
    public void println(int i) {
        pw.println(i);
    }

    /**
     * Prints a long followed by a newline
     * 
     * @param l the long to print
     */
    public void println(long l) {
        pw.println(l);
    }

    /**
     * Prints a double followed by a newline
     * 
     * @param d the double to print
     */
    public void println(double d) {
        pw.println(d);
    }

    /**
     * Prints a character followed by a newline
     * 
     * @param c the character to print
     */
    public void println(char c) {
        pw.println(c);
    }

    /**
     * Prints a newline
     */
    public void println() {
        pw.println();
    }

    /**
     * Prints an array of integers with spaces between elements
     * 
     * @param arr the array to print
     */
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) pw.print(" ");
            pw.print(arr[i]);
        }
        pw.println();
    }

    /**
     * Prints an array of longs with spaces between elements
     * 
     * @param arr the array to print
     */
    public void printArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) pw.print(" ");
            pw.print(arr[i]);
        }
        pw.println();
    }

    /**
     * Prints an array of objects with spaces between elements
     * 
     * @param arr the array to print
     */
    public void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) pw.print(" ");
            pw.print(arr[i]);
        }
        pw.println();
    }

    /**
     * Flushes the output stream
     */
    public void flush() {
        pw.flush();
    }

    /**
     * Closes the output stream
     */
    public void close() {
        if (pw != null) {
            pw.close();
        }
    }

    /**
     * Checks if there were any errors in the underlying PrintWriter
     * 
     * @return true if there were errors, false otherwise
     */
    public boolean checkError() {
        return pw.checkError();
    }
}