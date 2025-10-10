class Solution {
    public int[] solution(int[] A, int K) {
        int lastValue = 0;

        for (int i = 0; i < K; i++) {
            lastValue = A[A.length-1];
            for (int j = 1; j < A.length-1; j++) {
                A[j] = A[j-1];
            }
            A[0] = lastValue;
        }
        return A;
    }
}