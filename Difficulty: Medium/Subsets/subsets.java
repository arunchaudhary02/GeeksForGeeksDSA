class Solution {
    
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        
        ArrayList<Integer> subset = new ArrayList<>();
        
        backtracking(0, subset, arr);
        
        return result;
    }
    
    private void backtracking(int index, ArrayList<Integer> subset, int[] arr) {
        
        if(index == arr.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        
        // Not take
        backtracking(index + 1, subset, arr);
        
        
        // take
        subset.add(arr[index]);
        backtracking(index + 1, subset, arr);
        
        subset.removeLast();
    }
}