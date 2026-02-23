// User function Template for Java
class Solution {
    public int[] commonSlot(List<int[]> a, List<int[]> b, int d) {
        // code here
        
         // Sort list a by first element
        a.sort((x, y) -> Integer.compare(x[0], y[0]));
        
        // Sort list b by first element
        b.sort((x, y) -> Integer.compare(x[0], y[0]));
        
        int ptr1 = 0, ptr2 = 0;
        
        while(ptr1 < a.size() && ptr2 < b.size()) {
            
            int left = Math.max(a.get(ptr1)[0], b.get(ptr2)[0]);
            int right = Math.min(a.get(ptr1)[1], b.get(ptr2)[1]);
            
            if(right - left >= d) {
                return new int[]{left, left + d};
            }
            
            if(a.get(ptr1)[1] < b.get(ptr2)[1]) {
                ptr1++;
            }
            else{
                ptr2++;
            }
        }
        
        return new int[0];
        
    }
}
