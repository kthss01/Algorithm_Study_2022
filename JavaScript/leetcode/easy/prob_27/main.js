/**
 * easy
 * 27 Remove Element
 *
 * nums 바꾸라고 함
 * nums val 주어질 때
 * val을 nums에 지우고 정렬
 *
 * Constraints
 *  0 <= nums.length <= 100
 *  0 <= nums[i] <= 50
 *  0 <= val <= 100
 */

/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
const removeElement = function (nums, val) {
    const temp = nums.filter((num) => num != val);
    nums.length = temp.length;
    for (let i = 0; i < nums.length; i++) {
        if (i < temp.length) {
            nums[i] = temp[i];
        }
    }
    return nums.length;
};

var nums;
var val;

// ex1
nums = [3, 2, 2, 3];
val = 3;

console.log(nums);
console.log(removeElement(nums, val));
console.log(nums);

console.log("\n");

nums = [0, 1, 2, 2, 3, 0, 4, 2];
val = 2;

console.log(nums);
console.log(removeElement(nums, val));
console.log(nums);
