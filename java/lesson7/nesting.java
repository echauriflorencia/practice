import java.util.*;
class Solution {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
 
        for (char c : S.toCharArray()) {
            if ( c == '(' ) {
                stack.push((c));
            } else {
                
                if (stack.isEmpty()) {
                    return 0; 
                }
                char top = stack.pop();
                if ( (c == ')' && top != '(') ) {
                    return 0; 
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
