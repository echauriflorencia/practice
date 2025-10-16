class Solution {
    public int solution(int[] A) {
    Set<Integer> elements = new HashSet<>();

    for (int a : A) {
        if (a > A.length || elements.contains(a)) {
            return 0;
        } else {
            elements.add((a));
        }
    }

    return elements.size() == A.length ? 1 : 0;

    }
}