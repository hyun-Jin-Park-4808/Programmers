function solution(n) {
    let answer = 0;
    for(let i = 4; i <= n; i++) {
        if(isComposite(i)) {
            answer++;
        }
    }
    return answer;
}

function isComposite(num) {
    for(let i = 2; i <= Math.sqrt(num); i++) {
        if(num % i === 0) {
            return true;
        }
    }
    return false;
}