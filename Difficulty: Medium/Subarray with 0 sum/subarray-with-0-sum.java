class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        // Your code here
        
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash set
            if(sum == 0 || arr[i] == 0 || set.contains(sum)) {
                return true;
            }
            
            set.add(sum);
        }
        
        return false;
        
    }
}