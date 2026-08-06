class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Long> map = new HashMap<>();

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        for (int num : nums) {

            map.put(num, Math.min(map.getOrDefault(num, Long.MAX_VALUE), prefix)); 
            prefix += num;

            // Check if a subarray can start with value (num - k)
            if (map.containsKey(num - k)) {
                ans = Math.max(ans, prefix - map.get(num - k));
            }

            // Check if a subarray can start with value (num + k)
            if (map.containsKey(num + k)) {
                ans = Math.max(ans, prefix - map.get(num + k));
            }
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}
