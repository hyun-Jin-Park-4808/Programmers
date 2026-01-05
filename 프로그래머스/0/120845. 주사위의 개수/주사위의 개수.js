function solution(box, n) {
    return box.reduce((acc, value) => acc * Math.floor(value / n), 1)
}