class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> monotonicStack = new Stack<>();
        
        int n = arr.length;
        
        monotonicStack.push(arr[n - 1]);
        
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] >= monotonicStack.peek()) {
                monotonicStack.push(arr[i]);
            }
        }
        
        for(Integer ele : monotonicStack) {
            result.add(ele);
        }
        
        Collections.reverse(result);
        return result;
    }
}
