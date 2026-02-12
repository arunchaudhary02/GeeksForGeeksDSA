class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int n = arr.length;
        int result = 0;
        
        for(int i = 0; i < arr.length; i++) {
            
            // For any element arr[i] in an array of size n, it appears in exactly (i + 1) * (n - i) subarrays.
            result += ((i + 1) * (n - i)) * arr[i];
        }
        
        return result;
    }
}
