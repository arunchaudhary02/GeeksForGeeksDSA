// User function Template for Java
class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        
        int L = 0, R = arr.length - 1;
        
        int ans = -1;
        
        while(L <= R) {
            int mid = L + (R - L) / 2;
            
            if(x <= arr[mid]) {
                ans = mid;
                R = mid - 1;
            }
            else{
                L = mid + 1;
            }
        }
        
        return ans;
    }
}
