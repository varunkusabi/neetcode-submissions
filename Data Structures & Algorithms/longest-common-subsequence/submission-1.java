class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int[][] memo = new int[text1.length()][text2.length()];
       for(int[] row:memo){
        Arrays.fill(row,-1);
       }
       return check(0,0,text1,text2,memo); 
    }
    private int check(int i,int j,String text1,String text2,int[][] memo){
        if(i==text1.length() || j==text2.length()){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+check(i+1,j+1,text1,text2,memo);
        }
        memo[i][j] = Math.max(check(i+1,j,text1,text2,memo),check(i,j+1,text1,text2,memo));
        return memo[i][j];
    }
}
