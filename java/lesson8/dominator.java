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
        if (size > 0) {
            candidate = value;
        }


        int index = -1;
        int count = 0;

        for (int k = 0; k < N ; k++) {
            if (A[k] == candidate) {
                count += 1;
                index = k;
            }
        }
        if (count > N / 2) {
            return index;
        }

        return -1;
    }
}
