//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        
        List<List<Double>> tempArr = new ArrayList<>();
        helper(val, wt, tempArr);
        mergeSort(tempArr, 0, tempArr.size() - 1); // sorting in descending order with respect of 3 element
        
        double totalValue = 0;
        int totalCapacity = capacity;
        
        for(int i = 0; i < tempArr.size(); i++) {
            if(tempArr.get(i).get(1) <= totalCapacity) {
                totalValue += tempArr.get(i).get(0);
                totalCapacity -= tempArr.get(i).get(1);
            }
            else {
                totalValue += tempArr.get(i).get(0) / tempArr.get(i).get(1) * totalCapacity;
                break;
            }
        }
        
        return totalValue;
        
    }
    
    private void helper(List<Integer> val, List<Integer> wt, List<List<Double>> tempArr) {
        for(int i = 0; i < val.size(); i++) {
            List<Double> temp = new ArrayList<>();
            temp.add((double) val.get(i));
            temp.add((double) wt.get(i));
            temp.add((double) val.get(i) / wt.get(i));
            tempArr.add(temp);
        }
    }
    
    private void mergeSort(List<List<Double>> tempArr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(tempArr, left, mid);
            mergeSort(tempArr, mid + 1, right);
            merge(tempArr, left, mid, right);
        }
    }
    
    private void merge(List<List<Double>> tempArr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        List<List<Double>> leftList = new ArrayList<>();
        List<List<Double>> rightList = new ArrayList<>();
        
        for(int i = 0; i < n1; i++) {
            leftList.add(tempArr.get(left + i));
        }
        
        for(int i = 0; i < n2; i++) {
            rightList.add(tempArr.get(mid + i + 1));
        }
        
        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2) {
            if(leftList.get(i).get(2) < rightList.get(j).get(2)) {
                tempArr.set(k, rightList.get(j));
                j++;
            }
            else{
                tempArr.set(k, leftList.get(i));
                i++;
            }
            k++;
        }
        
        while(i < n1) {
            tempArr.set(k, leftList.get(i));
            i++;
            k++;
        }
        
        while(j < n2) {
            tempArr.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}