package Arrays;

public class StaticArray {

    // Keeps track of the number of elements currently stored
    private int length = 0;

    // Fixed-size underlying array
    private String[] arr;

    // Constructor
    // Time: O(1)
    // Space: O(n) - creates an array of size n
    public StaticArray(int length) {
        this.arr = new String[length];
    }

    /*
     * Adds an element at the end of the array.
     *
     * Example:
     * [item1, item2, null, null]
     *                    ↑
     *                  length
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void push(String item) {
        arr[length] = item;
        length++;
    }

    /*
     * Returns the element at the given index.
     *
     * Arrays provide direct/random access using an index.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public String get(int index) {
        return arr[index];
    }

    /*
     * Removes the last element.
     *
     * Example:
     *
     * Before:
     * [item1, item2, item3, item4]
     *                         ↑
     *                       length
     *
     * After:
     * [item1, item2, item3, null]
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void pop() {
        length--;
        arr[length] = null;
    }

    /*
     * Deletes an element from a specific index.
     *
     * If we delete an element from the middle,
     * all elements after it need to be shifted left.
     *
     * Example:
     *
     * Before:
     * [A, B, C, D, E]
     *     ↑
     *   delete index 1
     *
     * After:
     * [A, C, D, E, null]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void delete(int index) {

        // This variable is currently not being used
        String data = arr[index];

        shiftElements(index);
    }

    /*
     * Shifts all elements after the deleted index
     * one position to the left.
     *
     * Example:
     *
     * [A, B, C, D, E]
     *     ↑
     *   index = 1
     *
     * Step 1:
     * [A, C, C, D, E]
     *
     * Step 2:
     * [A, C, D, D, E]
     *
     * Step 3:
     * [A, C, D, E, E]
     *
     * Finally:
     * [A, C, D, E, null]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void shiftElements(int index) {

        // Remove the element at the given index
        arr[index] = null;

        // Shift every element after index one position to the left
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Remove the duplicate last element
        arr[arr.length - 1] = null;

        // One element has been removed
        length--;
    }

    public static void main(String[] args) {

        // Create a fixed-size array with capacity 5
        StaticArray staticArray = new StaticArray(5);

        // Add elements
        staticArray.push("item1");
        staticArray.push("item2");
        staticArray.push("item3");
        staticArray.push("item4");
        staticArray.push("item5");

        System.out.println(
            "length = " + staticArray.length +
            " arr = " + java.util.Arrays.toString(staticArray.arr)
        );

        // Delete element at index 4
        staticArray.delete(4);

        System.out.println(
            "length = " + staticArray.length +
            " arr = " + java.util.Arrays.toString(staticArray.arr)
        );
    }
}