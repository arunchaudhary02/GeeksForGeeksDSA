class Solution {

    void mergeSort(int arr[], int left, int right) {
        // code here
        
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            merge(arr, left, mid, right);
        }
    }
    
    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        for(int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        
        for(int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }
        
        int L = 0, R = 0, K = left;
        
        while(L < n1 && R < n2) {
            if(leftArr[L] < rightArr[R]) {
                arr[K++] = leftArr[L++];
            }
            else{
                arr[K++] = rightArr[R++];
            }
        }
        
        while(L < n1) {
            arr[K++] = leftArr[L++];
        }
        
        while(R < n2) {
            arr[K++] = rightArr[R++];
        }
    }
    
    
}