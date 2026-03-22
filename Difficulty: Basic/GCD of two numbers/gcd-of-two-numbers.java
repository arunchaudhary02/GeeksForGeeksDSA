class Solution {
    public static int gcd(int a, int b) {  // (Euclid Algorithm)
        // code here
        
        if (b == 0)
        return a;
    return gcd(b, a % b);
        
    }
    
    
}
