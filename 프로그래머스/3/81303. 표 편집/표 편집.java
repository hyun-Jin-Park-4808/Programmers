import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>(); // 삭제된 행의 인덱스 저장
        int[] up = new int[n + 2]; // U 연산 수행 후 현재 위치 변화 표시하기 위한 배열 
        int[] down = new int[n + 2]; // D 연산 수행 후 현재 위치 변화 표시하기 위한 배열
        
        for(int i = 0; i < n + 2; i++) {
            up[i] = i - 1; // 각 인덱스마다 U 연산 수행하면 1씩 줄어듬 
            down[i] = i + 1; // 각 인덱스마다 D 연산 수행하면 1씩 커짐
        }
        
        k++; // 현재 위치의 인덱스 값이므로 1 더해주기 
        
        for(String c : cmd) { // 명령어 배열 돌기 
            if(c.startsWith("C")) { // 삭제 연산 
                deleted.push(k); // 현재 위치 삭제 
                up[down[k]] = up[k]; // k의 아래에 있던 행의 윗 행은 k의 윗 행이 된다.  
                down[up[k]] = down[k]; // k의 위에 있던 행의 아래 행은 k의 아래 행이 된다. 
                k = n < down[k] ? up[k] : down[k]; // k 아래 행이 없으면 k의 위에 있던 행 선택, 아니면 아래 행 선택 
            } else if(c.startsWith("Z")) { // 복구하기 
                int restore = deleted.pop(); // 복구할 인덱스 뽑기 
                down[up[restore]] = restore; // 복구할 인덱스 기준으로 윗 행의 아래로 복구할 행이 생겨야 한다. 
                up[down[restore]] = restore; // 복구할 인덱스 기준으로 아래 행의 위로 복구할 행이 생겨야 한다. 
            } else { // U, D의 경우 
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]); // 몇 칸 이동할 지 구한다. 
                for(int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for(int i : deleted) {
            answer[i - 1] = 'X';
        }
            
        return new String(answer);
    }
}