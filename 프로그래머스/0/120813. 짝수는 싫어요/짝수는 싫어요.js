function solution(n) {
    return Array(Math.round(n/2)).fill(0).map((_, index) => index * 2 + 1);
}