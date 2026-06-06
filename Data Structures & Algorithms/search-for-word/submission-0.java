class Solution {
    private int R,C;
    private Set<Pair<Integer,Integer>> s=new HashSet<>();
    public boolean exist(char[][] board, String word) {
        R=board.length;
        C=board[0].length;

        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(word.charAt(0)==board[i][j])
                {
                    if(dfs(board,word,i,j,0))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word,int r,int c,int i)
    {
        if(i==word.length())
        {
            return true;
        }

        if(r<0 || c<0 || r>=R || c>=C || s.contains(new Pair<>(r,c)) || board[r][c]!=word.charAt(i))
        {
            return false;
        }
        
        s.add(new Pair<>(r,c));
        boolean res = dfs(board,word,r+1,c,i+1) || 
        dfs(board,word,r-1,c,i+1) || 
        dfs(board,word,r,c+1,i+1) || 
        dfs(board,word,r,c-1,i+1);

        s.remove(new Pair<>(r,c));

        return res; 
    }
}
