function solution(n) {
    return String(n)
    .split('')
    .reduce((sum, number) => sum + Number(number), 0);
}