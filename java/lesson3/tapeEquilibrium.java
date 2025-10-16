class Solution {
    public int solution(int[] A) {
        long totalSum = 0;
        for (int n : A) totalSum += n;

        long leftSum = 0;
        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            long rightSum = totalSum - leftSum;
            long diff = Math.abs(leftSum - rightSum);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return (int) minDiff;
    }
}
