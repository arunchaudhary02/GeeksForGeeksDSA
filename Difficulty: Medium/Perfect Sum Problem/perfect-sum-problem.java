
// Backtracking

/*
class Solution {
    // Function to calculate the number of subsets with a given sum
    
    int resultCount = 0;
    
    public int perfectSum(int[] nums, int target) {
        // code here
        
        recursion(0, 0, target, nums);
        
        return resultCount;
    }
    
    private void recursion(int index, int currSum, int target, int[] nums) {
        
        if(index == nums.length) {
            if(currSum == target) {
                resultCount++;
            }
            return;
        }
        
        // take
        recursion(index + 1, currSum + nums[index], target, nums);
        
        // Not Take
        
        recursion(index + 1, currSum, target, nums);
    }
}

*/


// DP 


class Solution {
    // Function to calculate the number of subsets with a given sum
    
    public int perfectSum(int[] nums, int target) {
        // code here
        
        int n = nums.length;
        Integer[][] dp = new Integer[n][target + 1];
        
        return recursion(0, 0, target, nums, dp);
        
    }
    
    private int recursion(int index, int currSum, int target, int[] nums, Integer[][] dp) {
        
        if(currSum > target) {
            return 0;
        }
        
        if(index == nums.length) {
            if(currSum == target) {
                return 1;
            }
            return 0;
        }
        
        if(dp[index][currSum] != null) {
            return dp[index][currSum];
        }
        
        int take = recursion(index + 1, currSum + nums[index], target, nums, dp);
        int notTake = recursion(index + 1, currSum, target, nums, dp);
        
        dp[index][currSum] = take + notTake;
        
        return dp[index][currSum];
    }
}