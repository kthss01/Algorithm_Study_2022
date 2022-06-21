/**
 * easy
 * 14 Longest Common Prefix
 * 
 * string 배열이 주어질 때 가장 긴 common prefix 반환하기
 * no common prefix면 빈 배열 반환
 * 
 * constraints
 *  1 <= strs.length <= 200
 *  0 <= strs[i].length <= 200
 *  strs[i] only lowercase alpahbet
 */

/**
 * @param {string[]} strs
 * @return {string}
 */
const longestCommonPrefix = function(strs) {
    const lens = strs.map(str => str.length);
    const minLength = Math.min(...lens);
    let ans = "";

    for (let i = 0 ; i < minLength; i++) {
        if (strs.filter(str => str[i] != strs[0][i]).length != 0) {
            break;
        }
        ans += strs[0][i];
    }

    return ans;
};

let strs = "";
let ans = "";

// ex1
strs = ["flower","flow","flight"];
ans = "fl";
console.log(longestCommonPrefix(strs), ans, longestCommonPrefix(strs) == ans);

// ex2
strs = ["dog","racecar","car"]
ans = "";
console.log(longestCommonPrefix(strs), ans, longestCommonPrefix(strs) == ans);

