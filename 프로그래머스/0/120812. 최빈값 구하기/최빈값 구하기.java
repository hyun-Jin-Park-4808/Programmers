import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        int mode = -1;
        int maxCount = 0;
        boolean isDuplicated = false;
        
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            
            if(count > maxCount) {
                maxCount = count;
                mode = value;
                isDuplicated = false;
            } else if(count == maxCount) {
                isDuplicated = true;
            }
        }
        
        return isDuplicated ? -1 : mode;
    }
}