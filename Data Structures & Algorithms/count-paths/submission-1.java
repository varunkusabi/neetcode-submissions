class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return check(0,0,m,n,memo);
    }
    int check(int i,int j,int m,int n,int memo[][]){
        if(i>=m|| j>=n){
            return 0;
        }
        if(memo[i][j]!=-1) return memo[i][j];
        if(i==m-1 && j==n-1){
            return 1;
        }
        memo[i][j] = check(i+1,j,m,n,memo)+check(i,j+1,m,n,memo);
        return memo[i][j];
    }
}
