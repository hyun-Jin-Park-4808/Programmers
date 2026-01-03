function solution(num_list) {
    return num_list.reduce(
        ([even, odd], n) => n % 2 === 0 ? [even + 1, odd] : [even, odd + 1], 
        [0, 0]
    );
}