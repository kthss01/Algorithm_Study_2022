// parentheses : 괄호

/**
 * easy
 * 20 Valid Parentheses
 * 
 * ( ) { } [ ] 가 주어질 때 valid한지 체크
 * 
 * Constraints 
 *  1 <= s.length <= 10^4
 *  s only ()[]{}
 */

/**
 * @param {string} s
 * @return {boolean}
 */
const isValid = function(s) {
    let ans = true;
    const arr = s.split('');

    const start = "({[";
    const end = ")}]";

    let stack = [];

    arr.forEach(c => {
        if (start.includes(c)) {
            stack.push(c);
        } else if (end.includes(c)) {
            const index = end.indexOf(c);
            const top = stack[stack.length - 1];
            if (top === start[index]) {
                stack.pop();
            } else {
                ans = false;
                return false;
            }
        }
    });

    ans &= stack.length === 0;

    return ans;
};

let s = "";
let ans;
const check = () => console.log(isValid(s) === ans);

// ex1
s = "()";
ans = true;
check();

// ex2 
s = "()[]{}";
ans = true;
check();

// ex3 
s = "(]";
ans = false;
check();