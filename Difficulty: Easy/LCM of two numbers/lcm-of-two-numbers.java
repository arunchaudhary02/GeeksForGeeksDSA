/*
class Solution {
    public int lcm(int a, int b) {
        // code here
        
        int greatest = Math.max(a, b);
        int smallest = Math.min(a, b);
        
        for(int i = greatest; i <= a * b; i += greatest) {
            if(i % smallest == 0) {
                return i;
            }
        }
        
        return a * b;
    }
}
*/

// Using GCD


class Solution {
    public int lcm(int a, int b) {
        // code here
        
        int lcm = (a * b) / gcd(a, b);
        
        return lcm;
    }
    
    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}



















