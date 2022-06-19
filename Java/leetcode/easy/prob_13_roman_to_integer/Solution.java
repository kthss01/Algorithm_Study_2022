package leetcode.easy.prob_13_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * Easy
 * Romatn to Integer
 * 
 * I - 1
 * V - 5
 * X - 10
 * L - 50
 * C - 100
 * D - 500
 * M - 1000
 * 
 * 로마자 주어질 때 숫자 출력
 * 
 * 주의
 *  IV - 4
 *  IX - 9
 *  XL - 40
 *  XC - 90
 *  CD - 400
 *  CM - 900
 * 
 * Constraints
 *  1 <= s.length <= 15
 *  s only character (I V X L C D M)
 *  guaranteed s valid (1 ~ 3999)
 */
class Solution {
    Map<Character, Integer> roman = new HashMap<>();

    Solution() {
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
    }

    // public int romanToInt(String s) {
    //     int number = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);
    //         char nextCh = ' ';

    //         if (i != s.length() - 1) {
    //             nextCh = s.charAt(i + 1);
    //         }

    //         if (ch == 'I') {
    //             if (nextCh == 'V') {
    //                 number += 4;
    //                 i++;
    //             } else if (nextCh == 'X') {
    //                 number += 9;
    //                 i++;
    //             } else {
    //                 number += roman.get(ch);
    //             }
    //         } else if (ch == 'X') {
    //             if (nextCh == 'L') {
    //                 number += 40;
    //                 i++;
    //             } else if (nextCh == 'C') {
    //                 number += 90;
    //                 i++;
    //             } else {
    //                 number += roman.get(ch);
    //             }
    //         } else if (ch == 'C') {
    //             if (nextCh == 'D') {
    //                 number += 400;
    //                 i++;
    //             } else if (nextCh == 'M') {
    //                 number += 900;
    //                 i++;
    //             } else {
    //                 number += roman.get(ch);
    //             }
    //         } else {
    //             number += roman.get(ch);
    //         }
    //     }

    //     return number;
    // }

    // better
    public int romanToInt(String s) {
        //special situations
        s = s.replace("IV","IIII");
        s = s.replace("IX","VIIII");
        s = s.replace("XL","XXXX");
        s = s.replace("XC","LXXXX");
        s = s.replace("CD","CCCC");
        s = s.replace("CM","DCCCC");

        int number = 0;

        for (Character ch : s.toCharArray()) {
            number += roman.get(ch);
        }

        return number;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String s;
        int ans;

        // ex1
        s = "III";
        ans = 3;
        System.out.println(sol.romanToInt(s));
        System.out.println(sol.romanToInt(s) == ans);

        // ex2
        s = "LVIII";
        ans = 58;
        System.out.println(sol.romanToInt(s));
        System.out.println(sol.romanToInt(s) == ans);

        // ex3
        s = "MCMXCIV";
        ans = 1994;
        System.out.println(sol.romanToInt(s));
        System.out.println(sol.romanToInt(s) == ans);
    }
}