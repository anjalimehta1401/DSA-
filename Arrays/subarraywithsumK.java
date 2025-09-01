import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0, ans = 0;
        mp.put(0, 1); // Initial condition to handle sum = k directly

        for (int num : nums) {
            sum += num; // Compute the prefix sum
            int find = sum - k; // Check if this sum exists before
            
            if (mp.containsKey(find)) {
                ans += mp.get(find); // Add the frequency of (sum - k)
            }
            
            mp.put(sum, mp.getOrDefault(sum, 0) + 1); // Update the hashmap
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, -2, 2, 4, 1};
        int k = 5;
        System.out.println("Number of subarrays with sum " + k + ": " + solution.subarraySum(nums, k));
    }
}
==============================


  Time Complexity (TC):

Single pass → O(n).

HashMap operations are average O(1).
 TC = O(n)

Space Complexity (SC):

The HashMap can store at most n different prefix sums in the worst case (e.g., strictly increasing cumulative sums).

No other significant extra space (just variables).
 SC = O(n)
