class Solution {
    public int solution(int order) {
        Character[] chars = {'3', '6', '9'};
        return (int) String.valueOf(order)
            .chars()
            .filter(ch -> ch == '3' || ch == '6' || ch == '9')
            .count();
    }
}