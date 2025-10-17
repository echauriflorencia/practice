class Solution {
    public int solution(int[] A) {
        double min = Double.MAX_VALUE;
        int start = 0;

        for (int i = 0; i < A.length - 1; i++) {
            double avg2 = ((A[i] + A[i + 1]) / 2.0);

            if (avg2 < min) {
                start = i;
                min = avg2;
            } 
            
            if (i < A.length - 2) {
            double avg3 = ((A[i] + A[i + 1] + A[i + 2]) / 3.0);
            if (avg3 < min) {
                start = i;
                min = avg3;
            }
            }
        }
        return start;
    }
}
