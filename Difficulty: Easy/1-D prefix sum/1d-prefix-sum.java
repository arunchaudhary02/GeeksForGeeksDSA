class Solution {
    public ArrayList<Integer> prefSum(int[] arr) {
        // code here
        int n = arr.length;

        // to store the prefix sum
        ArrayList<Integer> prefixSum = new ArrayList<>();

        // initialize the first element
        prefixSum.add(arr[0]);

        // Adding present element with previous element
        for (int i = 1; i < n; i++)
            prefixSum.add(prefixSum.get(i - 1) + arr[i]);

        return prefixSum;
    }
}