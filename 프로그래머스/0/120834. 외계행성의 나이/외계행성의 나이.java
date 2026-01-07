class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        for(char ch : String.valueOf(age).toCharArray()) {
            int num = ch - '0'; // '2' -> 2
            sb.append((char) ('a' + num)); // 'a' + 2: 97 + 2 = 99 => 'c'
        }
        return sb.toString();
    }
}