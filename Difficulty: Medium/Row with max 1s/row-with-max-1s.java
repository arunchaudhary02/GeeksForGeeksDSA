// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        
        int resultIndex = -1;
        int totalOne = 0;
        
        for(int index = 0; index < arr.length; index++) {
            int countOne = binarySearchCountOne(arr[index]);
            
            if(countOne > totalOne) {
                resultIndex = index;
                totalOne = countOne;
            }
        }
        
        return resultIndex;
    }
    
    private int binarySearchCountOne(int[] arr) {
        
        int n = arr.length;
        if(arr[n - 1] == 0) {
            return 0;
        }
        
        int left = 0, right = n - 1;
        
        int leftMostOneIndex = right;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(arr[mid] == 0) {
                left = mid + 1;
            }
            else{
                leftMostOneIndex = Math.min(leftMostOneIndex, mid);
                right = mid - 1;
            }
        }
        
        return n - leftMostOneIndex;
    }
    
}