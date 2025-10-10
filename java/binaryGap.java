class Solution {
    public int solution(int N) {
        int maxGap = 0;
        int currentGap = 0;
        boolean counting = false; // hasta que aparezca el primer 1

        while (N > 0) {
            if ((N & 1) == 1) { // bit menos significativo es 1
                if (counting) {
                    // cerramos un gap
                    if (currentGap > maxGap) {
                        maxGap = currentGap;
                    }
                }
                counting = true; // empezamos a contar después del primer 1
                currentGap = 0;
            } else if (counting) {
                currentGap++; // sólo contamos ceros después del primer 1
            }
            N >>= 1; // desplazamos bits a la derecha
        }

        return maxGap;
    }
}
