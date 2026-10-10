class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int maxlen =0;
        for(int i=0; i<n; i++){
            if(!set.contains(nums[i]-1)){
                int curr = nums[i];
                int len =1;
                while(set.contains(curr+1)){
                    curr++;
                    len++;
                }
                maxlen = Math.max(maxlen, len);
            }
        }
        return maxlen;
    }
}
