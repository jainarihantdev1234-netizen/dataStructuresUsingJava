class Solution {
    public int minDeletions(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 1;
        int count = 0;
        while(j < n){
            if(nums[i] == nums[j]){
                count++;
                j++;
            }
            else{
                i = j;
                j++;
            }
        }

        return count;

    }
}
