// Approach 1 

class Solution {
    public void reverseInGroups(int[] arr, int k) {
        // code here
        
        List<int[]> intervals = new ArrayList<>();
        int n = arr.length;
        
        int startPoint = 0;
        
        for(int end = k - 1; end < n; end += k) {
            intervals.add(new int[] {startPoint, end});
            startPoint = end + 1;
        }
        
        if(startPoint < n) {
            intervals.add(new int[] {startPoint, n - 1});
        }
        
        // Finding Answer
        
        for(int i = 0; i < intervals.size(); i++) {
            reverse(arr, intervals.get(i)[0], intervals.get(i)[1]);
        }
        
    }
    
    private void reverse(int[] arr, int L, int R) {
        
        while(L < R) {
            int temp = arr[R];
            arr[R] = arr[L];
            arr[L] = temp;
            L++;
            R--;
        }
    }
}


// Approach 2

/*
class Solution {
    public void reverseInGroups(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = k - 1;
        
        for(int i = 0; i < n; i++) {
            while(right >= n) {
                right--;
            }
            
            result[i] = arr[right];
            right--;
            if(left > right) {
                left = left + k;
                right = left + k - 1;
            }
        }
        
        for(int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
    }
}
*/