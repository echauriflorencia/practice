class Solution {
    public int solution(int[] A) {
        int[] numbers = new int[A.length];

        for (int a : A) {
            if (a > 0 && a <= A.length)
                numbers[a-1] = 1;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                return (i+1);
            }
        }
        return A.length +1;
    }
}