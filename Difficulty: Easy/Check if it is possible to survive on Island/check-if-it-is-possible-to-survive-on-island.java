//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String arr[] = in.readLine().trim().split("\\s+");
            int S = Integer.parseInt(arr[0]);
            int N = Integer.parseInt(arr[1]);
            int M = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.minimumDays(S, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumDays(int S, int N, int M){
        // code here
        
        int resultDay = 0;
        int foodStored = 0;
        int currentDay = 1; // if currentDay is multiple of 7 it's mean Sunday. Shop is Closed
        
        while(S > 0) {
            if(foodStored >= S * M) {
                break;
            }
            else if(currentDay != 7) {
                foodStored += N;
                resultDay++;
            }
            foodStored -= M;
             S--;
            if(foodStored < 0) {
                return -1;
            }
            
            currentDay++;
            
        }
        
        return resultDay;
    }
}