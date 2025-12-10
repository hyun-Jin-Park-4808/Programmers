function solution(array) {
    const map = new Map();
    
    for(const num of array) {
        map.set(num, (map.get(num) || 0) + 1);
    }
    
    const array2 = [...map].sort((a, b) => b[1] - a[1]);
    return array2.length === 1 || array2[0][1] > array2[1][1] ? array2[0][0] : -1;
}