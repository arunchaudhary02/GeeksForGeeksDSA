class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        return helperRecursion(0, 0, sum, arr);
    }
    
    static boolean helperRecursion(int index, int currSum, int target, int[] arr) {
        
        // ✅ If sum matched
        if(currSum == target) {
            return true;
        }
    
        // ✅ If we reached end
        if(index == arr.length) {
            return false;
        }
    
        // ✅ If sum exceeded (only valid for positive numbers)
        if(currSum > target) {
            return false;
        }
    
        // Take OR Not Take
        return helperRecursion(index + 1, currSum + arr[index], target, arr) ||
               helperRecursion(index + 1, currSum, target, arr);
            
    }
}