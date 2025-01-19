import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();
        int n = progresses.length;
        int[] daysLeft = new int[n];
        
        for(int i = 0; i < n; i++) { // 각 작업의 배포 가능일 계산 
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int count = 0; // 배포될 작업의 수
        int maxDay = daysLeft[0]; // 현재 배포될 작업 중 가장 늦게 배포될 작업의 배포 가능일 
        
        for(int i = 0; i < n; i++) {
            if(daysLeft[i] <= maxDay) { // 현재 작업의 배포 가능일이 앞선 작업의 배포 가능일보다 빠르면 
                count++; // 배포 아직 못함. 
            }
            else { // 더 느리면 
                answer.add(count); // 앞선 작업 배포 
                count = 1; // 배포될 작업의 수 초기화 
                maxDay = daysLeft[i]; // 다음 기능의 배포일로 maxDay 초기화 
            }
        }
        answer.add(count); // 마지막으로 카운트된 작업들 함께 배포 
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}