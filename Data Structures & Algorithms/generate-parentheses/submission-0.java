class Solution {
    public void check(int n,String a,int open,int close,List<String> s)
    {
        if(open==n && close==n)
        {
            s.add(a);
            return;
        }
        if(open<n)
        {
            check(n,a+'(',open+1,close,s);
        }
        if(close<open)
        {
            check(n,a+')',open,close+1,s);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> s=new ArrayList<>();
        check(n,"",0,0,s);
        return s;
    }
}
