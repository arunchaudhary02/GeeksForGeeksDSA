class Solution {
    public void reverseInGroups(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = k - 1;
        
        for(int i = 0; i < n; i++) {
            while(right >= n) {
                right--;
            }
            
            result[i] = arr[right];
            right--;
            if(left > right) {
                left = left + k;
                right = left + k - 1;
            }
        }
        
        for(int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
    }
}