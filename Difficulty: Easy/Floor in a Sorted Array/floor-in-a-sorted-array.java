class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        
        int L = 0, R = arr.length - 1;
        int ans = -1;
        
        while(L <= R) {
            int mid = L + (R - L) / 2;
            
            if(arr[mid] <= x) {
                ans = mid;
                L = mid + 1;
            }
            else{
                R = mid - 1;
            }
        }
        
        return ans;
    }
}
