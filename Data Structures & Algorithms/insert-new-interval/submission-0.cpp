class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& in, vector<int>& nw) {
        vector<vector<int>> ans;
        bool flag = false;
        int x = nw[0];
        int y = nw[1];
        int n = in.size();
        for(int i=0;i<n;i++){
            int a=in[i][0];
            int b=in[i][1];

            if(b<x){
                ans.push_back({a,b});
            }
            else if(a>y){
                if(!flag){
                    ans.push_back({x,y});
                    flag = true;
                }
                ans.push_back({a,b});
            }
            else{
                x=min(x,a);
                y=max(y,b);
            }
        }
        if(!flag){
            ans.push_back({x,y});
        }
        return ans;
    }

};
