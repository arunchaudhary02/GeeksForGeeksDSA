// User function Template for Java

class Solution {
    public int gcd(int n, int arr[]) {
        // code here.
        
        if(n == 0) {
            return 0;
        }
        
        int result = arr[0];
        
        for(int i = 1; i < n; i++) {
            result = findGcdOfTwo(result, arr[i]);
            
            // Optimization: If result reaches 1, the GCD of the whole array will be 1
            if(result == 1) {
                return result;
            }
        }
        
        return result;
    }
    
    private int findGcdOfTwo(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return findGcdOfTwo(b, a % b);
    }
}