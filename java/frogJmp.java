class Solution {
    public int solution(int X, int Y, int D) {
        int distance = Y - X;
        int jumps = distance / D;
        if (distance % D != 0) {
            jumps++;
        }
        return jumps;
        // return (int) Math.ceil((double) distance / D);

    }
}