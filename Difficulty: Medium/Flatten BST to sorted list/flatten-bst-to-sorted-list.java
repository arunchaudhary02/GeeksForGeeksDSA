/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public Node flattenBST(Node root) {
        // code here
        
        if(root == null) {
            return null;
        }
        
        Node head = flattenBST(root.left);
        root.left = null;
        root.right = flattenBST(root.right);
        
        if(head != null) {
            Node temp = head;
            while(temp.right != null) {
                temp = temp.right;
            }
            
            temp.right = root;
        }
        else{
            // If head is null, root becomes the head
            head = root;
        }
        
        return head;
    }
}
