package Baekjoon.Silver.Prob3_1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 후외 표기식2 - 실버 3
 * 
 * 후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때,
 * 그 식을 계산하는 프로그램 구하기
 * 
 * 입력
 *  피연산자의 개수 (1 <= N <= 26)
 *  후위 표기식이 주어짐 (피연산자 A ~ Z 영대문자
 *      A부터 순서대로 N개의 영대문자만 사용
 *      길이 100 넘지 않음)
 *  셋째 줄부터 N+2번째 줄까지는 각 피연산자에 대응하는 값 주어진다
 *  3번째 줄에는 A에 해당하는 값, 4번째 줄에는 B....
 *  그리고 피연산자에 대응하는 값은 100보다 작거나 같은 자연수
 * 
 * 출력
 *  계산 결과를 소숫점 둘째 자리까지 출력
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String op = br.readLine();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Double> stack = new Stack<>();

        for (char c : op.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                stack.push((double)arr[(c - 'A')]);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double result = 0;

                switch (c) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }
                // System.out.println(result);
                stack.push(result);
            }
        }

        System.out.printf("%.2f\n", stack.pop());
    }
}
