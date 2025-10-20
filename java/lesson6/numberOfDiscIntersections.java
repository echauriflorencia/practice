import java.util.*;

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        long[] start = new long[N];
        long[] end = new long[N];

        for (int i = 0; i < N; i++) {
            start[i] = (long)i - A[i];
            end[i] = (long)i + A[i];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        
        int open = 0;
        int intersections = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {

            while (j < N && end[j] < start[i] ) {
                open--;
                j++;
            }

            intersections += open;
            if (intersections > 10000000) return -1;

            open++;
        }

        return intersections;
    }
}