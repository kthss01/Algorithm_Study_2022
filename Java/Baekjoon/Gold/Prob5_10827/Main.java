package Baekjoon.Gold.Prob5_10827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * a^b - 골드 5
 * 
 * 실수 a와 정수 b가 주어졌을 때, 
 * a의 b 제곱을 정확하게 계산하기
 * 
 * a b 가 주어짐 (0 < a < 100, 1 <= b <= 100)
 * a는 최대 소수점 9자리
 * 소수가 0으로 끝나는 경우는 없다.
 * a는 항상 소수점이 포함되어 있다.
 *
 * a의 b 제곱 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        
        BigDecimal bc = new BigDecimal(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        
        String ans = bc.pow(b).toPlainString();

        System.out.println(ans);
    }
}
