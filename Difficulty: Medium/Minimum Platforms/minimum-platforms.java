//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        
        mergeSort(arr, 0, arr.length - 1);
        mergeSort(dep, 0, dep.length - 1);
        
        int ptrArrival = 0, ptrDep = 0;
        int count = 0, maxCount = 0;
        
        while(ptrArrival < arr.length) {
            if(arr[ptrArrival] <= dep[ptrDep]) {
                count++;
                ptrArrival++;
            }
            else{
                count--;
                ptrDep++;
            }
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
    
    private static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int leftLen = mid - left + 1;
        int rightLen = right - mid;
        
        int[] leftTemp = new int[leftLen];
        int[] rightTemp = new int[rightLen];
        
        for(int i = 0; i < leftLen; i++) {
            leftTemp[i] = arr[left + i]; 
        }
        for(int i = 0; i < rightLen; i++) {
            rightTemp[i] = arr[mid + i + 1];
        }
        
        int L = 0, R = 0, temp = left;
        while(L < leftLen && R < rightLen) {
            if(leftTemp[L] < rightTemp[R]) {
                arr[temp] = leftTemp[L];
                L++;
            }
            else{
                arr[temp] = rightTemp[R];
                R++;
            }
            temp++;
        }
        
        while(L < leftLen) {
            arr[temp] = leftTemp[L];
            L++;
            temp++;
        }
        
        while(R < rightLen) {
            arr[temp] = rightTemp[R];
            R++;
            temp++;
        }
    }
}
