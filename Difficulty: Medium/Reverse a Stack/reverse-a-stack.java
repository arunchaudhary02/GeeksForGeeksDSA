class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        
        if(st.isEmpty()) {
            return;
        }
        
        int top = st.pop();
        
        reverseStack(st);
        
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()) {
            temp.push(st.pop());
        }
        
        st.push(top);
        
        while(!temp.isEmpty()) {
            st.push(temp.pop());
        }
        
        
    }
}
