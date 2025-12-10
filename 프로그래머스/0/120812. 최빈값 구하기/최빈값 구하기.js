function solution(array) {
    const map = new Map();
    
    for(const num of array) {
        map.set(num, (map.get(num) || 0) + 1);
    }
    
    let mode = -1;
    let maxCount = 0;
    let isDuplicated = false;
    
    for(const [value, count] of map.entries()) {
        if(count > maxCount) {
            maxCount = count;
            mode = value;
            isDuplicated = false;
        } else if (count === maxCount) {
            isDuplicated = true;
        }
    } 
    return isDuplicated ? -1 : mode;
}