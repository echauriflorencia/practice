import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int N = A.length;

        int product1 = A[N - 1] * A[N - 2] * A[N - 3]; 
        int product2 = A[0] * A[1] * A[N - 1];         

        return Math.max(product1, product2);
    }
}