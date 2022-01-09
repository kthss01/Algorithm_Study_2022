package Baekjoon.Bronze.Prob2_2408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 큰 수 계산 - 브론즈 2
 * 
 * 어떤 임의의 수식이 입력으로 들어올 때 수식 계산하기
 * 수의 크기 -10^100 ~ 10^100 수식에 괄호 x
 * 소수점이 나올 경우, 소수점은 내린다.
 * 참고로, -5/2 = -3, 5/-2 = -3, -5/-2 = 2
 * 
 * 입력
 *  수의 개수 N (1 ~ 10)
 *  다음 2N-1 개의 줄에 수와 연산자(+,-,*,/)가 번갈아서 들어온다.
 * 
 * 출력
 *  첫째 줄에 계싼이 끝난 후 수를 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        BigInteger bi = new BigInteger(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            String op = br.readLine();

            String num = br.readLine();
            switch (op) {
                case "+":
                    bi = bi.add(new BigInteger(num));
                    break;
                case "-":
                    bi = bi.subtract(new BigInteger(num));
                    break;
                case "*":
                    bi = bi.multiply(new BigInteger(num));
                break;
                case "/":
                    bi = bi.divide(new BigInteger(num));
                break;
            }

            System.out.println("----" + bi);
        }

        System.out.println(bi);
    }
}
