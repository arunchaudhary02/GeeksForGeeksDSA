// User function Template for Java

class Solution {
    public int[] antiDiagonalPattern(int[][] matrix) {
        // Code here
        
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] result = new int[m * n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                treeMap.computeIfAbsent(i + j, k -> new ArrayList<>()).add(matrix[i][j]);
            }
        }
        
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()){
            List<Integer> value = entry.getValue();
            
            for(int i = 0; i < value.size(); i++) {
                result[index++] = value.get(i);
            }
        }
        
        return result;
    }
}