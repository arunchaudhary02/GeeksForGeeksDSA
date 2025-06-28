// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        
        int floorValue = -1;
        while(root != null) {
            if(root.data == x) {
                return x;
            }
            if(root.data < x) {
                floorValue = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        
        return floorValue;
    }
}