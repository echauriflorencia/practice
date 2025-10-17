import java.util.*;

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        if (N < 3) return 0;

        Arrays.sort(A);

        for (int i = 0; i < N - 2; i++) {
            long p = A[i];
            long q = A[i + 1];
            long r = A[i + 2];

            if (p + q > r) {
                return 1;
            }
        }

        return 0;
    }
}
