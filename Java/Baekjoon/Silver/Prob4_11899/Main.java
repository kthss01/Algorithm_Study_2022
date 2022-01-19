package Baekjoon.Silver.Prob4_11899;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호 끼워넣기 - 실버4
 * 
 * 올바르지 않은 괄호열이 주어질 때
 * 올바른 괄호열으로 만들기 위해 앞과 뒤에 붙여야 할 
 * 괄호의 최소 개수 구하기
 * 
 * 입력
 *  올바르지 않은 괄호열 S
 *      S 1 ~ 50
 * 출력
 *  앞과 뒤에 붙여야 할 괄호의 최소 개수 추력
 *  불가능한 경우는 주어지지 않음
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    ans++;
                }
            }
        }
        ans += stack.size();
        System.out.println(ans);
    }
}
