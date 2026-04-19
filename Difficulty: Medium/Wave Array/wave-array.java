class Solution {
    public void sortInWave(int arr[]) {
        // code here
        
        int n = arr.length;
        if(n == 0 || n == 1) {
            return;
        }
        
        for(int i = 1; i < n; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
        
    }
}
