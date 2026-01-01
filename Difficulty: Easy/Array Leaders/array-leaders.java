class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        Stack<Integer> monotonicStack = new Stack<>();
        
        int n = arr.length;
        monotonicStack.push(arr[n - 1]);
        
        for(int i = n - 2; i >= 0; i--) {
            int curr = arr[i];
            if(curr >= monotonicStack.peek()) {
                monotonicStack.push(curr);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!monotonicStack.isEmpty()) {
            result.add(monotonicStack.pop());
        }
        
        return result;
    }
}
