class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        
        int leftIndex = binarySearch(arr, target, true);
        
        // If target not found
        if(leftIndex == -1) {
            return 0;
        }
        
        int rightIndex = binarySearch(arr, target, false);
        
        return (rightIndex - leftIndex) + 1;
    }
    
    private int binarySearch(int[] arr, int target, boolean leftBias) {
        
        int L = 0, R = arr.length - 1;
        int resultIndex = -1;
        
        while(L <= R) {
            int mid = L + (R - L) / 2;
            
            if(arr[mid] < target) {
                L = mid + 1;
            }
            else if(target < arr[mid]) {
                R = mid - 1;
            }
            else{
                resultIndex = mid;
                if(leftBias) {
                    R = mid - 1;
                }
                else{
                    L = mid + 1;
                }
            }
        }
        
        return resultIndex;
    }
}
