
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // skip duplicate i

            int j = i + 1, k = n - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];

                if (s < 0) {
                    j++;
                } else if (s > 0) {
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // skip duplicates
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = sol.threeSum(nums);
        System.out.println(result);
    }
}
