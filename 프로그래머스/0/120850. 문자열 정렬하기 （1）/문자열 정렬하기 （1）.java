class Solution {
    public int[] solution(String my_string) {
        return my_string.chars() // character stream
            .filter(Character::isDigit) /// 숫자만 필터링
            .map(c -> c - '0') // int로 변환
            .sorted()
            .toArray();
    }
}