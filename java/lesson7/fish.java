class Solution {
    public int solution(int[] A, int[] B) {
        Stack<Integer> downstreams = new Stack<>();

        int survivors = 0;
        int N = A.length;

        for (int i = 0; i < N; i++) {
            int size = A[i];
            int direction = B[i];

            if (direction == 1){
                downstreams.push(size);
            } else {
                boolean eaten = false;

                while (!downstreams.isEmpty()) {
                    if (downstreams.peek() > size) {
                        eaten = true;
                        break;
                    } else {
                        downstreams.pop();
                    }
                }

                if (!eaten) {
                    survivors++;
                }
            }
            
        }

        return survivors + downstreams.size();
    }
}
