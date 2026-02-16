//Approach (Using Line Sweep)
//T.C : O(nlogn)
//S.C : O(n) to store events in map

class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        int n = start.length;

        // Ordered map: time -> change in active meetings
        TreeMap<Integer, Integer> events = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            events.put(start[i], events.getOrDefault(start[i], 0) + 1);
            events.put(end[i],   events.getOrDefault(end[i],   0) - 1);
        }

        int overlaps = 0;
        int maxOverlaps = 0;

        for (int delta : events.values()) {
            overlaps += delta;
            maxOverlaps    = Math.max(maxOverlaps, overlaps);
        }

        return maxOverlaps;
    }
}
