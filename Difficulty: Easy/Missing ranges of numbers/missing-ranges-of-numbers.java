class Solution {
    public List<List<Integer>> missingRanges(int[] arr, int lower, int upper) {
        
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        // 1️⃣ Check numbers missing before first element
        // Example: lower = 10, arr[0] = 14
        // Missing: 10 to 13
        if (lower < arr[0]) {
            res.add(Arrays.asList(lower, arr[0] - 1));
        }

        // 2️⃣ Check numbers missing between two consecutive elements
        // If difference > 1, then some numbers are missing
        // Example: 15 and 20 → missing 16 to 19
        for (int i = 0; i < n - 1; ++i) {
            if (arr[i + 1] - arr[i] > 1) {
                res.add(Arrays.asList(arr[i] + 1, arr[i + 1] - 1));
            }
        }

        // 3️⃣ Check numbers missing after last element
        // Example: last element = 45, upper = 50
        // Missing: 46 to 50
        if (upper > arr[n - 1]) {
            res.add(Arrays.asList(arr[n - 1] + 1, upper));
        }

        // Return all missing ranges
        return res;
    }
}
