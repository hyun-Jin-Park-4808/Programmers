function solution(age) {
    return [...String(age)]
        .map(numChar => String.fromCharCode('a'.charCodeAt(0) + +numChar)) // +"1" => 1
        .join('');
}