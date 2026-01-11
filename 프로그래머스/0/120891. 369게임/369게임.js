function solution(order) {
    return String(order).split("")
        .filter(num => ["3", "6", "9"].includes(num))
    .length;
}