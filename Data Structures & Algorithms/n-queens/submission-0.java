class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        solve(0,board,ans);
        return ans;
    }
    private void solve(int i,char[][] board,List<List<String>> ans)
    {
        if(i==board.length)
        {
            List<String> a=new ArrayList<>();
            for(char[] row:board)
            {
                a.add(new String(row));
            }
            ans.add(a);
            return;
        }

        for(int c=0;c<board.length;c++)
        {
            if(isSafe(i,c,board))
            {
                board[i][c]='Q';
                solve(i+1,board,ans);
                board[i][c]='.';
            }
        }
    }

    private boolean isSafe(int r,int c,char[][] board)
    {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
