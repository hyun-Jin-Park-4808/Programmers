function solution(my_string) {
    return my_string.match(/\d/g).map(Number).sort((a, b) => a - b);
}