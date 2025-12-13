class Solution {
    public static int gcd(int a, int b) { // 최대공약수
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }
    public int solution(int n) {
        return Math.abs(n) / gcd(n, 6);
    }
}

// 10 명 6 조각 => n과 6의 최소공배수 / 6 => 5 판 