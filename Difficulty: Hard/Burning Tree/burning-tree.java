//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            int target = Integer.parseInt(br.readLine());
            Node root = buildTree(s);

            Solution g = new Solution();
            System.out.println(g.minTime(root, target));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/

    public static int minTime(Node root, int target) {
        // code here
        
        Map<Node, Node> parentTrack = new HashMap<>(); // first is child, second is Parent
        markParent(root, parentTrack);
        
        Node targetNode = findTargetNode(root, target);
        
        return bfs(targetNode, parentTrack);
        
    }
    
    private static void markParent(Node root, Map<Node, Node> parentTrack) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            Node currNode = queue.poll();
            if(currNode.left != null) {
                parentTrack.put(currNode.left, currNode); 
                queue.offer(currNode.left);
            }
            
            if(currNode.right != null) {
                parentTrack.put(currNode.right, currNode);
                queue.offer(currNode.right);
            }
        }
    }
    
    private static Node findTargetNode(Node node, int target) {
        if(node == null) {
            return null;
        }
        
        if(node.data == target) {
            return node;
        }
        
        Node leftNode = findTargetNode(node.left, target);
        Node rightNode = findTargetNode(node.right, target);
        
        if(leftNode == null && rightNode == null) {
            return null;
        }
        else if(leftNode != null) {
            return leftNode;
        }
        else{
            return rightNode;
        }
    }
    
    private static int bfs(Node targetNode, Map<Node, Node> parentTrack) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(targetNode);
        visited.add(targetNode);
        
        int currentLevel = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int check = 0;
            
            for(int i = 0; i < size; i++) {
                Node currNode = queue.poll();
                if(currNode.left != null && !visited.contains(currNode.left)) {
                    check = 1;
                    queue.offer(currNode.left);
                    visited.add(currNode.left);
                }
                
                if(currNode.right != null && !visited.contains(currNode.right)) {
                    check = 1;
                    queue.offer(currNode.right);
                    visited.add(currNode.right);
                }
                
                if(parentTrack.get(currNode) != null && !visited.contains(parentTrack.get(currNode))) {
                    check = 1;
                    queue.offer(parentTrack.get(currNode));
                    visited.add(parentTrack.get(currNode));
                }
            }
            
            if(check == 1) {
                currentLevel++;
            }
        }
        
        return currentLevel;
    }
}




















