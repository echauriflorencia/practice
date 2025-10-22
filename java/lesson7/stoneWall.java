import java.util.*;
class Solution {
    public int solution(int[] H) {
        Stack<Integer> heights = new Stack<>();
        int cuboids = 0;

        for (int h : H) {
            while (!heights.isEmpty() && heights.peek() > h) {
                heights.pop();
            }

            if (heights.isEmpty() || heights.peek() < h) {
                heights.push(h);
                cuboids++;
            }
        }

        return cuboids;
    }
}