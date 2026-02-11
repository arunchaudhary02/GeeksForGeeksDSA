class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        stack.push(arr[n - 1]);
        
        for(int i = n - 2; i >= 0; i--) {
            if(stack.peek() <= arr[i]) {
                stack.push(arr[i]);
            }
        }
        
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }
}
