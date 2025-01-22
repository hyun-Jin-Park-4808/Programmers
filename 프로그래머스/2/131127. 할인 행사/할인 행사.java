import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length - 9; i++) { // 각 날마다 10일간 할인하는 제품 정보를 맵에 담아서 wantMap과 비교
            HashMap<String, Integer> discountMap = new HashMap<>();
            
            for(int j = i; j < i + 10; j++) {
                if(wantMap.containsKey(discount[j])) {
                    discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
                }
            }
            
            if(discountMap.equals(wantMap)) {
                answer++;
            }
        }
        return answer;
    }
}