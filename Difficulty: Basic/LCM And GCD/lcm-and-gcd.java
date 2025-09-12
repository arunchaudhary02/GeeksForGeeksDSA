class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int[] result = new int[2];
        
        result[1] = gcd(a, b);
        result[0] = (a * b) / result[1];
        
        return result;
        
    }
    
    private static int gcd(int a, int b) {
        // Euclidean Algorithm
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}