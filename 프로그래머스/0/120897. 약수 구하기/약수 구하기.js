function solution(n) {
    const divisors = [];
    for(let i = 1; i <= Math.sqrt(n); i++) {
        if(n % i === 0) {
            divisors.push(i);
            if(i !== n / i) {
                divisors.push(Math.floor(n / i));
            }
        }
    }
    return divisors.sort((a, b) => a - b);
}