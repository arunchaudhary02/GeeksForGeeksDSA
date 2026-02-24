class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        
        if(low >= high) {
            return;
        }
        
        int pivotIndex = partition(arr, low, high);
        
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
        
    }

    private int partition(int[] arr, int low, int high) {
        // code here
        
        int pivot = arr[high];
        int pivotIndex = low;
        
        for(int i = low; i < high; i++) {
            if(arr[i] <= pivot) {
                swap(arr, pivotIndex, i);
                pivotIndex++;
            }
        }
        
        swap(arr, pivotIndex, high);
        
        return pivotIndex;
    }
    
    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}