import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms( int [][] intervals){
        if( intervals == null || intervals.length == 0)
        return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });


        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });


        pq.add(intervals[0]);
        for(int i =0; i<intervals.length;i++){
            int[] curr = intervals[i];
            int[] prev = pq.poll();
            if(curr[0]<prev[1]){
                pq.add(prev);
                pq.add(curr);
            } else{
                prev[1]=curr[1];
                pq.add(prev);
            }
        }

        return pq.size();
    }
}
