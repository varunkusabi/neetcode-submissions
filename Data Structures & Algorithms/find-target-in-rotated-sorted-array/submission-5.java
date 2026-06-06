class Solution {
    public int binarysearch(int low,int high,int target,int[] nums)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(target<nums[mid])
            {
                high=mid-1;
            }
            else if(target>nums[mid])
            {
                low=mid+1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target)
    {
        int  low=0;
        int high=nums.length-1,mid=0;
        while(low<high)
        {
            mid=(low+high)/2;
            if(nums[high]<nums[mid])
            {
                low=mid+1;
            }
            else 
            {
                high=mid;
            }
        }
        int pivot=low;
        int a=binarysearch(0,pivot-1,target,nums);
        int b=binarysearch(pivot,nums.length-1,target,nums);
        if(a==-1)
        {
            return b;
        }
        return a;
    }

}
