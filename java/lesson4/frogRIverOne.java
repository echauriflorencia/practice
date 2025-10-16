class Solution {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0;
        int lastUpdate = 0;

        for (int op : A) {
            if (op >= 1 && op <= N) {
                int index = op - 1;

                if (counters[index] < lastUpdate) {
                    counters[index] = lastUpdate;
                }

                counters[index]++;

                if (counters[index] > maxCounter) {
                    maxCounter = counters[index];
                }
            } else if (op == N + 1) {
                lastUpdate = maxCounter;
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < lastUpdate) {
                counters[i] = lastUpdate;
            }
        }
        
        return counters;
    }
}