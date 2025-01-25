//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // Reverse the linked list
        head = reverseList(head);
        
        Node temp = head;
        int carry = 1; // Start with adding 1
        Node prev = null;

        // Traverse the list and handle carry
        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10; // Update the current node's value
            carry = sum / 10; // Calculate the carry for the next node
            prev = temp;
            temp = temp.next;
        }

        // If there is still a carry left, add a new node
        if (carry > 0) {
            prev.next = new Node(carry);
        }

        // Reverse the list back to original order
        head = reverseList(head);

        return head;
    }

    // Helper method to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
