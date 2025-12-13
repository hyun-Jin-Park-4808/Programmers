function solution(n) {
    return n / gcd(n, 6);
}

function gcd(a, b) {
    return b === 0 ? Math.abs(a) : gcd(b, a % b); 
}