class Solution {
    public int[] solution(int money) {
        int count = money / 5500;
        int change = money % 5500;
        return new int[]{count, change};
    }
}