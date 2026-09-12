class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean memo[][] = new Boolean[s1.length()+1][s2.length()+1];
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        for(Boolean[] row:memo){
            Arrays.fill(row,null);
        }
        return check(0,0,s1,s2,s3,memo);
    }
    boolean check(int i,int j,String s1,String s2,String s3,Boolean[][] memo){
        if(i==s1.length() && j==s2.length()){
            return true;
        }
        if(memo[i][j]!=null) return memo[i][j];
        int k= i+j;
        if(i < s1.length() && j < s2.length() && s1.charAt(i)==s3.charAt(k) && s2.charAt(j)==s3.charAt(k)){
            memo[i][j] = check(i+1,j,s1,s2,s3,memo) || check(i,j+1,s1,s2,s3,memo);
            return memo[i][j];
        }
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            memo[i][j] = check(i+1,j,s1,s2,s3,memo);
            return memo[i][j];
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            memo[i][j] = check(i,j+1,s1,s2,s3,memo);
            return memo[i][j];
        }
        memo[i][j] = false;
        return memo[i][j];
    }
}
