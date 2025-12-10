function solution(array) {
    return array.sort((a, b) => a - b)[Math.trunc(array.length / 2)];
}