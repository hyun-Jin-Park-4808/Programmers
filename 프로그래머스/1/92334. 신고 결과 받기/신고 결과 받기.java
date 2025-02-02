import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> reportedUser = new HashMap<>(); // 유저당 자신을 신고한 유저 집합 저장할 해시맵
        Map<String, Integer> count = new HashMap<>(); // 처리 결과 받은 유저와 받은 횟수를 저장할 해시맵
        
        for(String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];
            
            if(!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<>());
            }
            reportedUser.get(reportedId).add(userId);
        }
        
        for(Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if(entry.getValue().size() >= k) { // 신고당한 횟수가 정지 기준을 만족하면
                for(String uid : entry.getValue()) {
                    count.put(uid, count.getOrDefault(uid, 0) + 1); // 신고자별로 결과 메일 받은 수 저장
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}