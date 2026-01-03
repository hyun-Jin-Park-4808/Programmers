import java.util.*;

class Solution {
    public String solution(String rsp) {
        Map<Character, String> winners = new HashMap<>();
        winners.put('2', "0");
        winners.put('0', "5");
        winners.put('5', "2");
        
        StringBuilder sb = new StringBuilder();
        for(char c : rsp.toCharArray()) {
            sb.append(winners.get(c));
        }
        
        return sb.toString();
    }
}