/**
 * easy
 * 69. Sqrt(x)
 * x가 주어질 때 x의 제곱근 구하기
 * 내장함수 안쓰고 구하기
 * 소수점 버리고 출력
 * 
 * Constraints
 *  0 <= x <= 2^31 - 1
 */

/**
 * @param {number} x
 * @return {number}
 */
const mySqrt = function(x) {
    //return Math.floor(Math.sqrt(x));
    let n = 0;
    while (n * n <= x) {
        n++;
    }
    return n - 1;
};

let x, ans;

// ex1
x = 4;
ans = 2;
console.log(mySqrt(x), ans);

// ex2
x = 8;
ans = 2;
console.log(mySqrt(x), ans);