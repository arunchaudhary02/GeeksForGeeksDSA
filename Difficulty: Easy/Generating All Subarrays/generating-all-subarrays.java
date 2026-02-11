// User function Template for Java
class Solution {
    public List<List<Integer>> getSubArrays(int[] arr) {
        // code here
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            List<Integer> curr = new ArrayList<>();
            
            for(int j = i; j < arr.length; j++) {
                curr.add(arr[j]); 
                result.add(new ArrayList<>(curr));
            }
            
        }
        
        return result;
    }
}