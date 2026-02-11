
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int n = arr.length;
        
        int currSum = 0;
        int L = 0;
        
        for(int R = 0; R < n; R++) {
            currSum += arr[R];
            
            while(currSum > target && L < R) {
                currSum -= arr[L];
                L++;
            }
            
            if(currSum == target) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(L + 1);
                list.add(R + 1);
                return list;
            }
            
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        return result;
    }
}
