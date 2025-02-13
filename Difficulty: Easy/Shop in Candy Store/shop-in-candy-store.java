//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[]= new int[N];
            for(int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> cost = ob.candyStore(candies,N,K);
            System.out.println(cost.get(0)+" "+cost.get(1));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        // code here
        
        mergeSort(candies, 0, N - 1);
        
        int minCount = 0, maxCount  = 0;
        
        int L = 0, R = N - 1;
        
        while(L <= R) {
            minCount += candies[L];
            L++;
            R -= K;
        }
        
        L = 0;
        R = N - 1;
        
        while(L <= R) {
            maxCount += candies[R];
            R--;
            L += K;
        }
        
        return new ArrayList<>(List.of(minCount, maxCount));
        
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
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftTemp = new int[n1];
        int[] rightTemp = new int[n2];
        
        for(int i = 0; i < n1; i++) {
            leftTemp[i] = arr[left + i];
        }
        
        for(int i = 0; i < n2; i++) {
            rightTemp[i] = arr[mid + i + 1];
        }
        
        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2) {
            if(leftTemp[i] < rightTemp[j]) {
                arr[k] = leftTemp[i];
                i++;
            }
            else {
                arr[k] = rightTemp[j];
                j++;
            }
            k++;
        }
        
        while(i < n1) {
            arr[k] = leftTemp[i];
            i++;
            k++;
        }
        while(j < n2) {
            arr[k] = rightTemp[j];
            j++;
            k++;
        }
    }
}