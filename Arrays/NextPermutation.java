import java.util.*;

class Solution {

    public void rev(int[] a, int l, int h) {
        while (l <= h) {
            int temp = a[l];
            a[l] = a[h];
            a[h] = temp;
            l++;
            h--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        // Step 1: Find first decreasing element from right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // If no such element, reverse the whole array
        if (idx == -1) {
            rev(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the next greater element from right and swap
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        // Step 3: Reverse the suffix
        rev(nums, idx + 1, n - 1);
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums = {1, 2, 3};
        System.out.println("Original: " + Arrays.toString(nums));
        
        sol.nextPermutation(nums);
        
        System.out.println("Next permutation: " + Arrays.toString(nums));
    }
}
===============================================

  Total Time Complexity
Each step is at most linear, so:
TC = O(n)

Space Complexity
You only use a few variables (idx, temp, etc.).

No extra data structures.

SC = O(1) (in-place)
