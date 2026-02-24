class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        
        if(l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }
    
    private void merge(int[] arr, int l, int mid, int r) {
        
        int n1 = mid - l + 1;
        int n2 = r - mid;
        
        int[] leftTemp = new int[n1];
        int[] rightTemp = new int[n2];
        
        for(int i = 0; i < n1; i++) {
            leftTemp[i] = arr[l + i];
        }
        for(int i = 0; i < n2; i++) {
            rightTemp[i] = arr[mid + 1 + i];
        }
        
        int L = 0, R = 0;
        int K = l;
        
        while(L < n1 && R < n2) {
            if(leftTemp[L] < rightTemp[R]) {
                arr[K] = leftTemp[L];
                L++;
            }
            else{
                arr[K] = rightTemp[R];
                R++;
            }
            K++;
        }
        
        while(L < n1) {
            arr[K] = leftTemp[L];
            L++;
            K++;
        }
        
        while(R < n2) {
            arr[K] = rightTemp[R];
            R++;
            K++;
        }
    }
}