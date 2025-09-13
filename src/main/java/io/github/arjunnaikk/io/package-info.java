/**
 * Fast I/O Library for Java
 * 
 * This package provides high-performance input/output classes optimized for
 * competitive programming and applications requiring fast I/O operations.
 * 
 * <h2>Main Classes:</h2>
 * <ul>
 *   <li>{@link io.github.arjunnaikk.io.FastReader} - Optimized input reading with methods
 *       for reading various data types faster than standard Scanner or BufferedReader</li>
 *   <li>{@link io.github.arjunnaikk.io.FastWriter} - Optimized output writing with methods
 *       for writing various data types faster than standard PrintWriter or System.out</li>
 * </ul>
 * 
 * <h2>Usage Example:</h2>
 * <pre>{@code
 * try (FastReader reader = new FastReader();
 *      FastWriter writer = new FastWriter()) {
 *      
 *      int n = reader.nextInt();
 *      int[] arr = reader.nextIntArray(n);
 *      
 *      writer.println("Array contents:");
 *      writer.printArray(arr);
 *      writer.flush();
 * } catch (IOException e) {
 *      e.printStackTrace();
 * }
 * }</pre>
 * 
 * <h2>Performance Benefits:</h2>
 * <ul>
 *   <li>Uses BufferedReader/BufferedWriter for efficient I/O operations</li>
 *   <li>StringTokenizer for fast token parsing</li>
 *   <li>Optimized methods for common data types</li>
 *   <li>Bulk operations for arrays</li>
 * </ul>
 * 
 * @author Arjunnaikk
 * @version 1.0.0
 * @since 1.0.0
 */
package io.github.arjunnaikk.io;