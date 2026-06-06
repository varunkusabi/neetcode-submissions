class Solution {
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits)
    {
        if(digits.length()==0)
        {
            return ans;
        }
        check(0,"",digits);
        return ans;
    }
    private void check(int i,String a,String digits)
    {
        if(a.length()==digits.length())
        {
            ans.add(a);
            return;
        }

        String chars=digitToChar[digits.charAt(i) - '0'];
        for(char c:chars.toCharArray())
        {
            check(i+1,a+c,digits);
        }
    }
}
