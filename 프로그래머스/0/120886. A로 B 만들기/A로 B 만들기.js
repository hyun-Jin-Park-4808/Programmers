function solution(before, after) {
    return sortString(before) === sortString(after) ? 1 : 0;
}

function sortString(s) {
    return s.split("").sort().join("");
}