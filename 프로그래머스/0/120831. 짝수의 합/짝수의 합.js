function solution(n) {
    const a = Math.floor(n/2);
    return a*(a+1);
}

// 10 => 2, 2+2, 2+2+2, 2+2+2+2, 2+2+2+2+2 => 2 * (1+2+3+4+5) => 5*6/2 => (n * n+1)