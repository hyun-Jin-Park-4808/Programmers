import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0 ; i < progresses.length ; i++) {
            que.add(i); // 큐에 인덱스 하나씩 추가
        }
        
        List<Integer> result = new ArrayList<>();
        int days = 0; // 현재까지 걸린 일수
        int count = 0; // 동시 배포할 작업 수

        while(!que.isEmpty()) {
            int index = que.poll(); // 인덱스 하나 꺼내오기 
            int expiration // 현재 인덱스의 작업 완료까지 걸리는 일수 
                = (int) Math.ceil((double) (100 - progresses[index]) / speeds[index]); 
            
            if(expiration > days) { // 현재 인덱스의 작업 완료까지 걸리는 일수가 현재까지 걸린 일수보다 크면 
                if(days != 0) { // 현재까지 걸린 일수가 아예 없는 경우가 아니면
                    result.add(count); // 결과 리스트에 누적된 동시 배포 작업 수 더해주고  
                    count = 0; // 동시 배포 작업 수 0으로 초기화 
                }
                days = expiration; // 현재까지 걸린 일수 업데이트 
            }
            count++; // 동시 배포할 작업 수 증가
        }
        
        result.add(count); // 남은 배포할 작업수 추가
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}