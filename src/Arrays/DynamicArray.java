package data_structures.arrays.array_implementation;

import java.util.Arrays;

/*
 * Implementation of our own Dynamic Array Data Structure.
 *
 * Similar concept to Java's ArrayList.
 */
public class DynamicArray {

    // Underlying array used to store elements.
    private String[] array;

    // Total number of elements the underlying array can hold.
    private int capacity;

    // Number of elements currently stored in the array.
    private int currentLength;

    /*
     * Constructor
     *
     * Initially:
     * capacity = 1
     * currentLength = 0
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public DynamicArray() {
        array = new String[1];
        capacity = 1;
        currentLength = 0;
    }

    /*
     * Returns the element at the given index.
     *
     * Arrays provide direct/random access.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public String get(int index) {

        // Validate index against the number of actual elements.
        if (index >= 0 && index < currentLength) {
            return array[index];
        }

        return "Index Out Of Bound";
    }

    /*
     * Adds an element at the end of the DynamicArray.
     *
     * If the array is full, we:
     * 1. Create a new array with double capacity.
     * 2. Copy existing elements.
     * 3. Replace the old array.
     *
     * Time Complexity:
     *   Amortized: O(1)
     *   Worst case: O(n) when resizing
     *
     * Space Complexity:
     *   O(n) when resizing
     */
    public void push(String value) {

        // Check if the underlying array is full.
        if (currentLength == capacity) {

            // Double the capacity.
            String[] tempArray = new String[capacity * 2];

            // Copy existing elements to the new array.
            for (int i = 0; i < currentLength; i++) {
                tempArray[i] = array[i];
            }

            // Replace old array with new array.
            array = tempArray;

            // Update capacity.
            capacity = capacity * 2;
        }

        // Add new element at the next available position.
        array[currentLength] = value;

        // Increase number of elements.
        currentLength++;
    }

    /*
     * Replaces the element at the given index.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void replace(int index, String value) {

        // Validate index.
        if (index >= 0 && index < currentLength) {
            array[index] = value;
        } else {
            System.err.println("Index out of bounds");
        }
    }

    /*
     * Removes the last element.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void pop() {

        // Make sure the array is not empty.
        if (currentLength > 0) {

            // Remove reference to the last element.
            array[currentLength - 1] = null;

            // Decrease logical size.
            currentLength--;
        }
    }

    /*
     * Deletes an element at the given index.
     *
     * All elements after the deleted element
     * are shifted one position to the left.
     *
     * Example:
     *
     * Before:
     * [A, B, C, D, E]
     *     ↑
     *  delete(1)
     *
     * After:
     * [A, C, D, E, null]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void delete(int index) {

        // Validate index.
        if (index < 0 || index >= currentLength) {
            System.err.println("Index out of bounds");
            return;
        }

        // Shift elements to the left.
        for (int i = index; i < currentLength - 1; i++) {
            array[i] = array[i + 1];
        }

        // Remove duplicate reference at the end.
        array[currentLength - 1] = null;

        // Decrease logical size.
        currentLength--;
    }

    /*
     * Returns a new array containing only the actual elements.
     *
     * The underlying array may have unused capacity.
     *
     * Example:
     *
     * Internal:
     * [A, B, C, null, null, null]
     *
     * getArray():
     * [A, B, C]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String[] getArray() {

        // Create an array only for actual elements.
        String[] tempArray = new String[currentLength];

        // Copy actual elements.
        for (int i = 0; i < currentLength; i++) {
            tempArray[i] = array[i];
        }

        return tempArray;
    }

    /*
     * Returns the number of elements currently stored.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int length() {
        return currentLength;
    }

    /*
     * Returns the total capacity of the underlying array.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int capacity() {
        return capacity;
    }

    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray();

        // Add elements.
        dynamicArray.push("apple");
        dynamicArray.push("ball");
        dynamicArray.push("cat");
        dynamicArray.push("dog");

        System.out.println(
            "Array Length: " + dynamicArray.length()
        );

        System.out.println(
            "Array Capacity: " + dynamicArray.capacity()
        );

        System.out.println(
            "Array: " + Arrays.toString(dynamicArray.getArray())
        );

        // Get element at index 2.
        System.out.println(
            "Item at index 2: " + dynamicArray.get(2)
        );

        // Replace element at index 1.
        dynamicArray.replace(1, "world");

        System.out.println(
            "After replace: " +
            Arrays.toString(dynamicArray.getArray())
        );

        // Remove last element.
        dynamicArray.pop();

        System.out.println(
            "After pop: " +
            Arrays.toString(dynamicArray.getArray())
        );

        // Delete element at index 1.
        dynamicArray.delete(1);

        System.out.println(
            "After delete: " +
            Arrays.toString(dynamicArray.getArray())
        );

        System.out.println(
            "Array Length: " + dynamicArray.length()
        );
    }
}