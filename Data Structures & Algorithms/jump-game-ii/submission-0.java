class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if (n <= 1) {
            return 0;
        }

        int jumps =0;
        int farthest_jump = 0,current_jump_end=0;

        for(int i=0;i<n;i++){
            farthest_jump = Math.max(farthest_jump,i+nums[i]);

            if(i==current_jump_end){
                jumps++;
                current_jump_end = farthest_jump;
            }

            if(current_jump_end >= n-1){
                break;
            }
        }
        return jumps;
    }
}
