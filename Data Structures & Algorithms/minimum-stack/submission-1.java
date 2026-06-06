class MinStack {
    private Stack<int[]> st=new Stack<>();
    // st.push(new int[]{0,Integer.MAX_VALUE});
    int ans=Integer.MAX_VALUE;

    public MinStack() {
    }
    
    public void push(int val) {
        if(st.empty())
        {
            st.push(new int[]{val,val});
        }
        else
        {
            int[] top=st.peek();
            int mn=top[1];
            st.push(new int[]{val,Math.min(mn,val)});

        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        int[] top=st.peek();
        return top[0];
    }
    
    public int getMin() {
        int[] top=st.peek();
        return top[1];
    }
}
