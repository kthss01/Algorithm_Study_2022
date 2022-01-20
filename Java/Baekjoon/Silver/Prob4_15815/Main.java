package Baekjoon.Silver.Prob4_15815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 천재 수학자 성필 - 실버 4
 * 
 * 중위 연산자 -> 후위 연산자
 * 
 * 후위연산자 계산하기
 * 
 * 입력
 *  길이 100 넘지 않는 수식 예제 입력과 같이 공백 없이 입력
 *  수식 0 ~ 9 숫자, 연산자 + - * / 로만
 *  또한 수식의 계산 중간 과정의 모든 결과는
 *  항상 2,147,483,647을 넘지 않는 정수
 *  0으로 나누는 경우 x
 * 출력
 *  수식의 답 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for (char ch : exp.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int n1 = stack.pop();
                int n2 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(n1 + n2);
                        break;
                    case '-':
                        stack.push(n2 - n1);
                        break;
                    case '*':
                        stack.push(n1 * n2);
                        break;
                    case '/':
                        stack.push(n2 / n1);
                        break;
                }
            } else {
                stack.push(ch - '0');
            }
        }
        System.out.println(stack.pop());
    }
}
