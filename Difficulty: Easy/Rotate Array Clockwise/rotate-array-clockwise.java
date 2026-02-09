class Solution {
    public void rotateclockwise(int[] arr, int k) {
        // code here
        
        k = k % arr.length;
        
        if(k == 0 || k == arr.length) {
            return;
        }
        
        int[] temp = new int[arr.length];
        int index = 0;
        
        for(int i = arr.length - k; i < arr.length; i++) {
            temp[index++] = arr[i];
        }
        
        for(int i = 0; i < arr.length - k; i++) {
            temp[index++] = arr[i];
        }
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}