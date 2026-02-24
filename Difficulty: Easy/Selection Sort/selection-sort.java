class Solution {
    void selectionSort(int[] arr) {
        // code here
        int n = arr.length;
        
        for(int i = 0; i < n - 1; i++) {
            int indexOfSmallest = i;
            
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[indexOfSmallest]) {
                    indexOfSmallest = j;
                }
            }
            
            if(indexOfSmallest != i) {
                int temp = arr[i];
                arr[i] = arr[indexOfSmallest];
                arr[indexOfSmallest] = temp;
            }
        }
    }
}