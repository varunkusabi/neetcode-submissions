class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,ans=0;
        Set<Character> st=new HashSet<>();
        while(j<s.length())
        {
            while(st.contains(s.charAt(j)))
            {
                st.remove(s.charAt(i));
                i++;
            }
            st.add(s.charAt(j));
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;

    }
}
