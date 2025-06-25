/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        inOrder(ans, currentPath, root);
        
        return ans;
    }
    
    private static void inOrder(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> currentPath, Node node) {
        if(node == null) {
            return;
        }
        
        currentPath.add(node.data);
        
        if(node.left == null && node.right == null) {
            ans.add(new ArrayList<>(currentPath));
        }
        else{
            inOrder(ans, currentPath, node.left);
            inOrder(ans, currentPath, node.right);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
    
}