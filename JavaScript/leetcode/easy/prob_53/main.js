/**
 * medium
 * 53. Maximum Subarray
 * 부분배열 중 최대값 구하기
 *
 * constraints
 *  1 <= nums.length <= 10^5
 *  -10^4 <= nums[i] <= 10^4
 *
 * O(n) solution
 *  trying divide and conquer approach 접근
 *      => dp 쓰라는거
 *  => dp가 아닌거 같기도함
 *      memoization은 맞는듯
 *      현재 값을 더했을 때 음수가 되면 바꾸고
 *      아니면 계속 더해가면 됨
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
const maxSubArray = function (nums) {
    if (nums.length === 0) return 0;
    let exp = [];
    let result = -Infinity;
    let sum = 0;
    nums.forEach((num) => {
        if (sum >= 0) {
            exp.push(num);
            sum += num;
        } else {
            sum = num;
            exp = [num];
        }

        result = Math.max(result, sum);
    });

    let temp = 0;
    let keepAdd = true;
    let last = 0;
    exp = exp.filter((e) => {
        temp += e;
        if (temp === result) {
            keepAdd = false;
            last = e;
        }
        return keepAdd;
    });
    exp.push(last);
    console.log(exp);
    return result;
};

let nums;
let ans;

// ex1
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4];
ans = 6;
console.log(maxSubArray(nums), ans);

// ex2
nums = [1];
ans = 6;
console.log(maxSubArray(nums), ans);

// ex3
nums = [5, 4, -1, 7, 8];
ans = 23;
exp = [];
console.log(maxSubArray(nums), ans);
