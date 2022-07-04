/**
 * easy 
 * 67. Add Binary
 * 
 * two binary strings a, b 
 * return sum as binary string
 * 
 * Constraints
 *  1 <= a.length, b.lengthg <= 10^4
 *  a and b consist only 0, 1
 *  leading zeros not
 */

/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
const addBinary = function(a, b) {
    const aBinary = BigInt('0b' + a);
    const bBinary = BigInt('0b' + b);
    const sum = aBinary + bBinary;
    return sum.toString(2);
};

let a, b, ans;

// ex1
a = "11";
b = "1";
ans = "100";
console.log(addBinary(a, b), ans);

// ex2
a = "1010";
b = "1011";
ans = "10101";
console.log(addBinary(a, b), ans);

a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
ans = "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
console.log(addBinary(a, b) === ans);