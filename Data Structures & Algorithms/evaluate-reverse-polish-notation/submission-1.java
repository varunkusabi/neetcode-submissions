class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        
        for (String token : tokens) {
            // if token is an operator
            if (token.equals("+")) {
                int b = s.pop();
                int a = s.pop();
                s.push(a + b);
            } else if (token.equals("-")) {
                int b = s.pop();
                int a = s.pop();
                s.push(a - b);
            } else if (token.equals("*")) {
                int b = s.pop();
                int a = s.pop();
                s.push(a * b);
            } else if (token.equals("/")) {
                int b = s.pop();
                int a = s.pop();
                s.push(a / b); // integer division
            } else {
                // otherwise, it's a number (positive, negative, or multi-digit)
                s.push(Integer.parseInt(token));
            }
        }
        
        return s.peek();
    }
}
