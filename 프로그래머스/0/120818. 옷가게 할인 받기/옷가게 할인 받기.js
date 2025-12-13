function solution(price) {
    if(price >= 500000) {
        return Math.floor(80 * price / 100);
    }
    if(price >= 300000) {
        return Math.floor(90 * price / 100);
    }
    if(price >= 100000) {
        return Math.floor(95 * price / 100);
    }
    return price;
}