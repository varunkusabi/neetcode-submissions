#include <vector>
#include <numeric>
using namespace std;


class Solution {
public:
    bool check(int target,int sum,int i,vector<int>& nums,int n)
    {
        if(i>=n)
        {
            return false;
        }
        if(target==sum)
        {
            return true;
        }
        return check(target+nums[i],sum-nums[i],i+1,nums,n) || check(target,sum,i+1,nums,n);    
    }
    bool canPartition(vector<int>& nums) {
        int sum=accumulate(begin(nums),end(nums),0);
        return check(0,sum,0,nums,nums.size());
    }
};
