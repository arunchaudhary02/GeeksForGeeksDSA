//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        
        List<Pair> meeting = new ArrayList<>();
        for(int i = 0; i < start.length; i++) {
            meeting.add(new Pair(start[i], end[i], i));
        }
        
        mergeSort(meeting, 0, meeting.size() - 1);
        
        int count = 1;
        int lastMeetingTime = meeting.get(0).end;
        
        for(int i = 1; i < meeting.size(); i++) {
            if(meeting.get(i).start > lastMeetingTime) {
                count++;
                lastMeetingTime = meeting.get(i).end;
            }
        }
        
        return count;
    }
    
    class Pair{
        int start;
        int end;
        int initialIndex;
        Pair(int start, int end, int initialIndex) {
            this.start = start;
            this.end = end;
            this.initialIndex = initialIndex;
        }
    }
    
    private void mergeSort(List<Pair> meeting, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(meeting, left, mid);
            mergeSort(meeting, mid + 1, right);
            merge(meeting, left, mid, right);
        }
    }
    
    private void merge(List<Pair> meeting, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        List<Pair> leftList = new ArrayList<>();
        List<Pair> rightList = new ArrayList<>();
        
        for(int i = 0; i < n1; i++) {
            leftList.add(meeting.get(left + i));
        }
        
        for(int i = 0; i < n2; i++) {
            rightList.add(meeting.get(mid + i + 1));
        }
        
        int i = 0, j = 0, k = left;
        
        while(i < n1 && j < n2) {
            if(leftList.get(i).end <= rightList.get(j).end) {
                meeting.set(k, leftList.get(i));
                i++;
            }
            else {
                meeting.set(k, rightList.get(j));
                j++;
            }
            k++;
        }
        
        while(i < n1) {
            meeting.set(k, leftList.get(i));
            i++;
            k++;
        }
        
        while(j < n2) {
            meeting.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
}
