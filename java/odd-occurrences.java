import java.util.*;

class Solution {
    public int solution(int[] A) {
        Set<Integer> numbers = new HashSet<>();

        for (int n : A) {
            if (numbers.contains(n)) {
                numbers.remove(n);   // si ya está, lo removemos (se formó un par)
            } else {
                numbers.add(n);      // si no está, lo agregamos
            }
        }

        // al final, quedará un solo número sin pareja
        return numbers.iterator().next();
    }
}
