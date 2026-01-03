class Solution {
    // Function to remove duplicates from the given array.
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int ele : arr) {
            if(!set.contains(ele)) {
                result.add(ele);
            }
            set.add(ele);
        }
        
        return result;
    }
}
