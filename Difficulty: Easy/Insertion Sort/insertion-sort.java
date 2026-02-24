class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // code here
        int n = arr.length;
        
        for(int i = 1; i < n; i++) {
            int currentNum = arr[i];
            int j = i - 1;
            
            while(j >= 0 && arr[j] > currentNum) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = currentNum;
        }
    }
}