class Solution {
    
    ArrayList<ArrayList<Integer>> result;
    
    public ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        // code here
        
        result = new ArrayList<>();
        Arrays.sort(arr);
        
        backtrack(0, arr, new ArrayList<>());
        
        return result;
    }
    
    private void backtrack(int index, int[] arr, ArrayList<Integer> subSet) {
        
        if(index == arr.length) {
            result.add(new ArrayList<>(subSet));
            return;
        }
        
        subSet.add(arr[index]);
        backtrack(index + 1, arr, subSet);
        
        while(index + 1 < arr.length && arr[index] == arr[index + 1]) {
            index++;
        }
        
        subSet.remove(subSet.size() - 1);
        backtrack(index + 1, arr, subSet);
    }
}
