import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        
        int minCase = numbers[0] * numbers[1];
        int maxCase = numbers[n - 1] * numbers[n - 2];
        
        return Math.max(minCase, maxCase);
    }
}