package io.github.arjunnaikk.io;

import java.io.IOException;

/**
 * Example usage of FastReader and FastWriter classes
 * 
 * @author Arjunnaikk
 * @version 1.0.0
 */
public class Example {
    public static void main(String[] args) {
        try (FastReader reader = new FastReader();
             FastWriter writer = new FastWriter()) {
            
            writer.println("Fast IO Library Example");
            writer.println("Enter an integer:");
            writer.flush();
            
            // Read input (this would wait for user input in real usage)
            // int n = reader.nextInt();
            // writer.println("You entered: " + n);
            
            // Example with array operations
            writer.println("\nExample with array:");
            int[] numbers = {1, 2, 3, 4, 5};
            writer.print("Array: ");
            writer.printArray(numbers);
            
            writer.flush();
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}