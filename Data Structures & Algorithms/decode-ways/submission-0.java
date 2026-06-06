class Solution {
    private int count(int i,String s)
    {
        if(i==s.length())
        {
            return 1;
        }
        if(s.charAt(i)=='0')
        {
            return 0;
        }
        int res=count(i+1,s);
        if(i<s.length()-1)
        {
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7'))
            {
                res=res+count(i+2,s);
            }
        }
        return res;
    }
    public int numDecodings(String s) {
        return count(0,s);
    }
}
