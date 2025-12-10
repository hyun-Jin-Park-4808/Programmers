class Solution {
    public int solution(int num1, int num2) {
        if(num1 >= 0 && num1 <= 10000 && num2 >= 0 && num2 <= 10000) {
            return num1 == num2 ? 1 : -1;
        }
        return -1;
    }
}