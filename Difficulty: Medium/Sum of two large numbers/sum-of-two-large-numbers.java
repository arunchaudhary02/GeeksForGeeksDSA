// User function Template for Java
import java.math.*;

class Solution {
    String findSum(String s1, String s2) {
        // code here
        
        BigInteger a = new BigInteger(s1); 
		BigInteger b = new BigInteger(s2);
		
		return (a.add(b)).toString(); 
    }
}