class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        for(char c : my_string.toCharArray()) {
            if(!String.valueOf(c).equals(letter)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}