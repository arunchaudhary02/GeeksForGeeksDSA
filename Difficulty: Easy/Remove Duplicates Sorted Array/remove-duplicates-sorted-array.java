class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        
        ArrayList<Integer> result = new ArrayList<>();
         
        HashSet<Integer> s = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (!s.contains(arr[i])) { 
                s.add(arr[i]);  
                result.add(arr[i]);
            }
        }

        
        return result;
    }
}
