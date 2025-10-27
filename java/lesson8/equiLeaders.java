class Solution {
    public int solution(int[] A) {
        int N = A.length;
        int size = 0;
        int value = 0;

        for (int i = 0; i < N; i++){
            if (size == 0) {
                size += 1;
                value = A[i];
            } else {
                if (value != A[i]) 
                    size--;
                else
                    size++;
            }
        }

        int candidate = -1;
        if (size > 0) 
            candidate = value;

        int count = 0;
        for (int k = 0; k < N ; k++) {
            if (A[k] == candidate) {
                count ++;
            }
        }

        if (count <= N / 2) 
            return 0;

        int equiLeaders = 0;
        int leaderCountLeft = 0;

        for (int i = 0; i < N - 1; i ++) {
            if (A[i] == candidate)
                leaderCountLeft++;

            int leadersLeft = leaderCountLeft;
            int leadersRight = count - leaderCountLeft;

            if (leadersLeft > (i + 1) / 2 &&
                leadersRight > (N - i -1) / 2) {
                    equiLeaders++;
            }
        }

        return equiLeaders;
    }
}