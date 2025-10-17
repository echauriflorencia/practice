class Solution {
    public int solution(int[] A) {
        if (A.length == 0)
            return 0;

        int count = 1;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] != A[i + 1]) 
                count++;
        }
        return count;
    }
}