import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>(); // 인형 담을 바구니 생성
        int answer = 0; // 사라진 인형 수
        
        // 게임 보드 안의 각 열에 대한 스택 생성 
        Stack<Integer>[] boardStacks = new Stack[board.length];
        for(int i = 0; i < boardStacks.length; i++) {
            boardStacks[i] = new Stack<>();
        }
        
        
        // 게임 보드 맨 아랫줄부터 돌면서 각 열의 스택에 인형 쌓기 
        for(int i = board.length - 1; i >= 0; i--) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] > 0) {
                    boardStacks[j].push(board[i][j]);
                }
            }
        }
        
        // moves 순회하면서 각 열에서 인형 뽑아 바구니에 추가
        for(int move: moves) {
            if(!boardStacks[move - 1].isEmpty()) { // 해당 열에 인형 존재하면 
                int doll = boardStacks[move - 1].pop(); // 인형 뽑기
                if(!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop(); // 같은 인형이면 터뜨리기 
                    answer += 2;
                } else {
                    bucket.push(doll); // 다른 인형이면 그냥 바구니에 담기 
                }
            }
        }
        return answer;
    }
}