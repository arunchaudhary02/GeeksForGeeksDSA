class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // code here
        if(start == end) return 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, start});
        
        int mod = 1000;
        boolean[] visited = new boolean[mod];
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int[] currNode = queue.poll();
            
            for(int ele : arr) {
                int nextValue = (int) (((long) ele * currNode[1]) % mod);
                
                if(nextValue == end) {
                    return currNode[0] + 1;
                }
                
                if(visited[nextValue] == false) {
                    visited[nextValue] = true;
                    queue.offer(new int[]{currNode[0] + 1, nextValue});
                }
            }
        }
        
        return -1;
        
    }
}