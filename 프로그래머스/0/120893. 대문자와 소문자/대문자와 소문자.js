function solution(my_string) {
    return [...my_string]
        .map(s => s.toUpperCase() === s 
             ? s.toLowerCase() 
             : s.toUpperCase())
        .join("");
}