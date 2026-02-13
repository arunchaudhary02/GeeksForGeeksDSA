
class Solution {
    public boolean isSubset(int a[], int b[]) {
        
        // Store frequency of elements in a[]
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Check elements of b[]
        for(int num : b) {
            
            // If element not present OR frequency finished
            if(!map.containsKey(num) || map.get(num) == 0) {
                return false;
            }
            
            // Decrease frequency
            map.put(num, map.get(num) - 1);
        }
        
        return true;
    }
}
