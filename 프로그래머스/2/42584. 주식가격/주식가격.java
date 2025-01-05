import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            // 가격이 떨어지는 경우 계산 
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i); // 가격 안떨어지면 스택에 쌓기 
        }
        
        while(!stack.isEmpty()) { // 끝까지 가격 안 떨어진 애들 계산하기 
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }
        return answer;
    }
}