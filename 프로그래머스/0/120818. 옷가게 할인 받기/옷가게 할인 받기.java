class Solution {
    public int solution(int price) {
        if(price >= 500000) return 80 * price / 100;
        if(price >= 300000) return 90 * price / 100;
        if(price >= 100000) return 95 * price / 100;
        return price;
    }
}