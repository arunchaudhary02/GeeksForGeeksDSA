class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        
        Arrays.sort(stalls);
        
        int left = 1;   // minimum possible distance
        int right = stalls[n - 1] - stalls[0];  // maximum possible distance
        
        int result = 0;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(canWePlace(stalls, mid, k)) {
                result = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canWePlace(int[] stalls, int distance, int k) {
        int countCowsPlaced = 1;
        int lastCowPosition = stalls[0];
        
        for(int i = 1; i < stalls.length; i++) {
            if(stalls[i] - lastCowPosition >= distance) {
                countCowsPlaced++;
                lastCowPosition = stalls[i];
            }
        }
        
        if(countCowsPlaced >= k) {
            return true;
        }
        else{
            return false;
        }
    }
}