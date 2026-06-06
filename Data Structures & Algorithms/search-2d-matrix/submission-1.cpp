class Solution {
public:
    bool searchMatrix(vector<vector<int>>& mat, int target) {
        int n=mat.size();
        int m=mat[0].size();
        int start=0,end=m-1,row=0;
        for(int i=0;i<n;i++)
        {
            if(mat[i][0]<=target && target<=mat[i][m-1])
            {
                row=i;
                break;
            }
        }
        cout<<row<<endl;

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(target>mat[row][mid])
            {
                start=mid+1;
            }
            else if(target<mat[row][mid])
            {
                end=mid-1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
};
