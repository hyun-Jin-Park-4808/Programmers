import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        
        for(String n : s1) {
            set1.add(n);
        }
        
        for(String n : s2) {
            set2.add(n);
        }
        set1.retainAll(set2);
        return set1.size();
    }
}