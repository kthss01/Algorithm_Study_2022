package Baekjoon.Bronze.Prob3_1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 부호 - 브론즈 3
 * 
 * N개의 정수가 주어지면
 * 이 정수들의 합 S의 부호 구하기
 * 
 * 입력
 * 총 3개의 테스트 셋
 * 각 테스트 셋의 첫째 줄 N 1 ~ 100,000
 * 둘째 줄부터 N개의 줄에 걸쳐 각 정수가 주어짐
 * 주어지는 정수의 절대값은 9223372036854775807보다 작거나 같다
 * 
 * 출력
 * 총 3개의 줄에 각 테스트 셋에 대해 N개의 정수들의 합 부호 출력
 * S = 0이면 "0"
 * S > 0 "+"
 * S < 0 "-"
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());

            BigInteger bi = new BigInteger(br.readLine());

            for (int j = 0; j < n - 1; j++) {
                bi = bi.add(new BigInteger(br.readLine()));
            }

            if (bi.signum() == 1) {
                sb.append("+");
            } else if (bi.signum() == -1) {
                sb.append("-");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
