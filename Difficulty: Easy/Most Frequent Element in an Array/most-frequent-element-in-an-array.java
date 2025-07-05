class Solution {
    public int mostFreqEle(int[] arr) {
        // code here
        
        Arrays.sort(arr);

        
        int maxCnt = 1, res = arr[0], currCnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
                currCnt++;
            else
                currCnt = 1;
            
            if (currCnt > maxCnt || (currCnt == maxCnt && arr[i] > res)) {
                maxCnt = currCnt;
                res = arr[i];
            }
        }

        return res;
    }
}