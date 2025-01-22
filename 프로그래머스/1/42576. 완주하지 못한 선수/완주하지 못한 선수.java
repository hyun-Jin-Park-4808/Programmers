import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String string : completion) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        
        for(String string: participant) {
            if(map.getOrDefault(string, 0) == 0) {
                return string;
            }
            map.put(string, map.get(string) - 1);
        }
        return "";
    }
}