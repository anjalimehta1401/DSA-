import java.util.*;

public class RemoveDuplicatesExample {

    static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1; // length of unique portion
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 3, 4};

        int newLength = removeDuplicates(arr);

        System.out.println("Length after removing duplicates = " + newLength);

        System.out.print("Unique elements: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
====================

  Time & Space Complexity:

Time: O(n) (one scan).

Space: O(1) (in-place, no extra array).
