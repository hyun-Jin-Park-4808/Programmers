import java.util.*;
class Solution {
    public int solution(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        for(int offset = 0; offset < str.length; offset++) {
            Stack<Character> stack = new Stack<>();
            boolean isCorrect = true;
            
            for(int i = 0; i < str.length; i++) {
                char c = str[(offset + i) % str.length];
                switch(c) {
                        case '(' -> stack.push(')');
                        case '{' -> stack.push('}');
                        case '[' -> stack.push(']');
                        case ')', '}', ']' -> {
                            if(stack.isEmpty() || stack.pop() != c) {
                                isCorrect = false;
                                break;
                            }
                        }
                }
            }
            if(stack.isEmpty() && isCorrect) {
                count ++;
            } 
        }
        return count;
    }
}