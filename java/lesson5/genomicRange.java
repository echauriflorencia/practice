class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[][] prefix = new int[3][N+1];

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            for (int j = 0; j < 3; j++)
                prefix[j][i+1] = prefix[j][i];

            if (c == 'A') prefix[0][i+1]++;
            else if (c == 'C') prefix[1][i+1]++;
            else if (c == 'G') prefix[2][i+1]++;
        }

        int[] result = new int[M];

        for (int k = 0; k < M; k++) {
            int from = P[k];
            int to = Q[k] + 1; 

            if (prefix[0][to] - prefix[0][from] > 0)
                result[k] = 1;
            else if (prefix[1][to] - prefix[1][from] > 0)
                result[k] = 2;
            else if (prefix[2][to] - prefix[2][from] > 0)
                result[k] = 3;
            else
                result[k] = 4;
        }

        return result;
    }
}
