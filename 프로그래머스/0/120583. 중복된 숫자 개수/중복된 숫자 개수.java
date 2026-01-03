import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        return Arrays.stream(array)
            .map(num -> num == n ? 1 : 0)
            .sum();
    }
}