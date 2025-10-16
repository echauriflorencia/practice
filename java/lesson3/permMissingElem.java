class Solution {
    public int solution(int[] A) {
        int N = A.length;
        long expectedSum = (long)(N + 1) * (N + 2) / 2;
        int actualSum = 0;

        for (int a : A) {
            actualSum += a;
        }

        return (int)expectedSum - actualSum;
    }
}