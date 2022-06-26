/**
 * easy
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
 */

let exp;

/**
 * @param {number[]} nums
 * @return {number}
 */
const maxSubArray = function(nums) {
    
};

let nums;
let ans;

// ex1
nums = [-2,1,-3,4,-1,2,1,-5,4];
ans = 6;
console.log(maxSubArray(nums), exp, ans);

// ex2
nums = [1];
ans = 6;
console.log(maxSubArray(nums), exp, ans);

// ex3
nums = [5,4,-1,7,8];
ans = 23;
console.log(maxSubArray(nums), exp, ans);