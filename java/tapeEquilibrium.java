class Solution {
    public int solution(int[] A) {
        int totalSum = 0;
        int leftSum = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int a : A) {
            totalSum += a;
        }

        for (int p = 0; p < A.length; p++) {
            leftSum += A[p];
            int rightSum = totalSum - leftSum;
            int diff = Math.abs(leftSum - rightSum);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }
}