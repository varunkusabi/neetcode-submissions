class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][5001];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return check(0,amount,coins,memo);
    }
    private int check(int i,int amount,int[] coins,int[][] memo){
        if(amount==0){
            return 1;
        }
        if(amount<0 || i>=coins.length){
            return 0;
        }
        if(memo[i][amount]!=-1) return memo[i][amount];
        memo[i][amount] = check(i,amount-coins[i],coins,memo)+check(i+1,amount,coins,memo);
        return memo[i][amount];
    }
}
