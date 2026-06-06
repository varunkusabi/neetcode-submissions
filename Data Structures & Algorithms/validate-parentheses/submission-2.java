class Solution {
    public boolean isValid(String s) 
    {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<n)
        {
            if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='(')
            {
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')' && !st.empty() && st.peek()=='(')
            {
                st.pop();
            }
            else if(s.charAt(i)==']' && !st.empty() && st.peek()=='[')
            {
                st.pop();
            }
            else if(s.charAt(i)=='}' && !st.empty() && st.peek()=='{')
            {
                st.pop();
            }
            else
            {
                return false;
            }
            i++;
        }
        return st.empty();
    }
}
