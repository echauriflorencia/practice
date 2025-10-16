class Solution {
    public int solution(int[] A) {
        int eastCars = 0;
        int pairs = 0;

        for (int a : A) {
            if (a == 0) {
                eastCars++;
            } else {
                pairs += eastCars;
                if (pairs > 1000000000) {
                    return -1;
                }
            }
        }
        return pairs;
    }
}