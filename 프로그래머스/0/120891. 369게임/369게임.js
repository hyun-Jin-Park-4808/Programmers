function solution(order) {
    return [...String(order)]
        .filter(num => ["3", "6", "9"].includes(num))
    .length;
}