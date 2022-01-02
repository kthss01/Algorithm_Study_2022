package Prob5_18301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Rats - 브론즈 5 (영어 문제)
 * 
 * n1, n2, n12가 주어지고
 * 
 * 계산식
 *  N := [(n1+1)(n2+1)/(n12+1)-1] (floor)
 * 이 주어질 때
 * 값 구하기
 * 
 * 입력
 *  n1, n2, n12 공백 구분
 *  (0 ~ n1,n2 ~ 10000)
 *  (0 ~ n12 ~ min(n1,n2))
 * 출력
 *  N
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(token.nextToken());
        int n2 = Integer.parseInt(token.nextToken());
        int n12 = Integer.parseInt(token.nextToken());

        int n = (n1 + 1) * (n2 + 1) /(n12 + 1) - 1;
        System.out.println(n);
    }
}
