class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        
        // Step 1: Sort by start time
        // Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        // Step 2: Check for overlap
        for(int i = 1; i < arr.length; i++) {
            
            // If current meeting starts before previous ends -> overlap
            if(arr[i][0] < arr[i - 1][1]) {
                return false;
            }
        }
        
        return true;
        
    }
}