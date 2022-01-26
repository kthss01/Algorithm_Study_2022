package Baekjoon.Silver.Prob5_1312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.StringTokenizer;

/**
 * 소수 - 실버 5
 * 
 * 분자 A, 분모 B 두 수를 나누었을 때
 * 소숫점 아래 N번째 자리 구하려고 함
 * 
 * ex) A = 3, B = 4, N = 1
 *      A / B = 0.75 -> 7
 * 
 * 입력
 *  A, B (1 <= A, B <= 100,000)
 *  N (1 <= N <= 1,000,000) 공백을 경계로 주어짐
 * 
 * 출력
 *  A / B 했을 때 소숫점 아래 N번째 수 출력
 * 
 * -> 힌트 나눗셈을 구현한다는 생각으로 접근해야하는 거 같음
 * 
 * 3 4 => 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());

        double c = (double) a / b;

        int r = a % b;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (r * 10) / b;
            r = (r * 10) % b;
        }
        System.out.println(ans);
    }
}
