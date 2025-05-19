//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        
        int n = arr.length;
        int[] hash = new int[n  + 1];
        
        for(int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }
        
        int repeatNum = 0;
        int missingNum = 0;
        
        for(int i = 1; i < n + 1; i++) {
            if(hash[i] == 0) {
                missingNum = i;
            }
            else if(hash[i] == 2) {
                repeatNum = i;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeatNum);
        ans.add(missingNum);
        return ans;
    }
}
