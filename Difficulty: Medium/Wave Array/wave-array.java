class Solution {
    public void sortInWave(int arr[]) {
        // code here
        
        int n = arr.length;
        if(n == 1) {
            return;
        }
        
        if(n % 2 != 0) {
            n--;
        }
        
        for(int i = 0; i < n; i+= 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        
    }
}
