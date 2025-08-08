// User function Template for Java

class Solution {
    public static ArrayList<Integer> factorial(int n) {
        // code here
        List<Integer> nums = new ArrayList<>(Collections.nCopies(10000, 0));
        nums.set(0, 1);
        
        int[] size = new int[1]; // Using array to simulate pass-by-reference
        size[0] = 1;
        for(int multiplier = 2; multiplier <= n; multiplier++) {
            multiply(nums, size, multiplier);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = size[0] - 1; i >= 0; i--) {
            result.add(nums.get(i));
        }
        
        return result;
    }
    
    private static void multiply(List<Integer> nums, int[] size, int multiplier) {
        int carry = 0;
        for(int i = 0; i < size[0]; i++) {
            int result = nums.get(i) * multiplier + carry;
            nums.set(i, result % 10);
            carry = result / 10;
        }
        
        while(carry > 0) {
            nums.add(size[0], carry % 10);
            size[0]++;
            carry = carry / 10;
        }
        
    }
}