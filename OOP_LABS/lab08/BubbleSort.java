import java.util.Arrays;

// Ex 8.5 (Challenge)
public class BubbleSort {
    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Integer[] nums = {5, 2, 9, 1, 7};
        String[] words = {"pear", "apple", "mango", "fig"};
        bubbleSort(nums);
        bubbleSort(words);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(words));
        // int[] will not work: generic type arguments must be reference types. T can be Integer
        // but never int, and an int[] is not an Integer[] (arrays of primitives are not arrays of
        // objects). Also int has no compareTo method. Type erasure means T becomes Comparable at
        // run time, which again needs objects. Use Integer[] or write a separate int[] overload.
    }
}
