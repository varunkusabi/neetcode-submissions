class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return check(0,'b',prices,memo);
    }
    private int check(int i,char c,int[] prices,int[][] memo){
        if(i>=prices.length){
            return 0;
        }
        int state = (c == 'b') ? 0 : 1;
        if(memo[i][state]!=-1){
            return memo[i][state];
        }
        if(c=='b'){
            memo[i][state] = Math.max(check(i+1,'b',prices,memo) ,-prices[i]+check(i+1,'s',prices,memo));
            return memo[i][state];
        }
        memo[i][state] = Math.max(check(i+1,'s',prices,memo),check(i+2,'b',prices,memo)+prices[i]);
        return memo[i][state];
    }
}
