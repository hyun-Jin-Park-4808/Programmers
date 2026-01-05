function solution(numbers) {
    numbers.sort((a, b) => a - b);
    const n = numbers.length;
    return Math.max((numbers[0] * numbers[1]), (numbers[n - 1] * numbers[n - 2]));
}