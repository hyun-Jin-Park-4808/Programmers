import java.util.*;

class Solution {
    // 만들 수 있는 메뉴 구성과 총 주문 수 저장할 해시 맵 
    private static Map<Integer, HashMap<String, Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        for(int i : course) {
            courseMap.put(i, new HashMap<>());
        }
        
        for(String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }
        
        ArrayList<String> answer = new ArrayList<>();
        
        for(HashMap<String, Integer> count : courseMap.values()) { // 모든 코스 후보 돌면서 
            count.values()
                .stream()
                .max(Comparator.comparingInt(o -> o)) // 가장 주문 빈도수 높은 코스 찾음 
                .ifPresent(cnt -> count.entrySet() // 코스에 대한 메뉴 수가 가능할 때만 
                          .stream()
                          .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1) // 최소 2명 이상 주문된 조합
                          .forEach(entry -> answer.add(entry.getKey()))); // 코스 메뉴만 정답 리스트에 추가 
        }
        
        Collections.sort(answer); // 오름차순 정렬 
        return answer.toArray(new String[0]); // 리스트 크기에 맞춰 배열 크기 알아서 전환 
    }
    
    // 만들 수 있는 모든 조합 재귀 함수로 구현 
    public static void combinations(int idx, char[] order, String result) {
        if(courseMap.containsKey(result.length())) { // 필요한 코스 메뉴 수와일치하는 것만 저장 
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) + 1); // 해당 코스 수 1 증가 
        }
        
        for(int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }
}