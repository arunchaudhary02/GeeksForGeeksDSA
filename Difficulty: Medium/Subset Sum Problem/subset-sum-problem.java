class Solution {
    
    static int n;
    static Boolean[][] dp;

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        n = arr.length;
        dp = new Boolean[n][sum + 1];
        return recursion(arr, 0, sum);
    }
    
    private static boolean recursion(int[] arr, int index, int target) {
        if(target == 0) {
            return true;
        }
        
        if(n <= index || target < 0) {
            return false;
        }
        
        if(dp[index][target] != null) {
            return dp[index][target];
        }
        
        boolean take = false;
        if(arr[index] <= target) {
            take = recursion(arr, index + 1, target - arr[index]);
        }
        boolean notTake = recursion(arr, index + 1, target);
        
        return dp[index][target] = take || notTake;
        
    }
}