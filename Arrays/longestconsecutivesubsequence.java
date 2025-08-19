import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // Step 1: Add all numbers to the HashSet
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // Step 2: Check sequences
        for (int it : set) {
            // only start counting if "it-1" is not in the set (start of sequence)
            if (!set.contains(it - 1)) {
                int cnt = 1;
                int x = it;

                while (set.contains(x + 1)) {
                    x += 1;
                    cnt += 1;
                }

                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    // Main function to test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Input: [100, 4, 200, 1, 3, 2]");
        System.out.println("Longest Consecutive Sequence: " + sol.longestConsecutive(nums1)); // Expected 4

        int[] nums3 = {};
        System.out.println("Input: []");
        System.out.println("Longest Consecutive Sequence: " + sol.longestConsecutive(nums3)); // Expected 0
    }
}


============================

  Time Complexity (TC):

Adding all elements to HashSet: O(n) (amortized O(1) per insert).

Iterating through each element & checking consecutive sequence: Each number is visited at most once → O(n).

Total = O(n)

Space Complexity (SC):

HashSet stores all n elements → O(n).

Constant extra variables.
