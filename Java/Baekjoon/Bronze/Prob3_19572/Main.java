package Baekjoon.Bronze.Prob3_19572;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가뭄(Small) - 브론즈 3
 * 
 * 세 칸이 있음 
 *  1,2 칸 뿌리는 a
 *  1,3 b
 *  2,3 c
 * a,b,c 모두 양의 실수
 * a,b,c가 같을 수 있는 d 구하기
 * 
 * 입력
 *  d1, d2, d3 (1 <= d1,d2,d3 <= 1000000)
 * 
 * 출력
 *  조건에 맞을 수 없으면 -1
 *  맞을 수 있으면 1 출력
 *      다음 줄 소수 첫째 자리까지 반올림한 것을 공백 구분 출력
 * 
 * d1 = a + b
 * d2 = a + c
 * d3 = b + c
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int d1 = Integer.parseInt(token.nextToken());
        int d2 = Integer.parseInt(token.nextToken());
        int d3 = Integer.parseInt(token.nextToken());

        double sum = (d1 + d2 + d3) / 2.0; // a b c
        double a = sum - d3;
        double b = sum - d2;
        double c = sum - d1;

        if (a > 0 && b > 0 && c > 0 
            && a + b == d1 && a + c == d2 && b + c == d3) {
            System.out.println(1);
            System.out.printf("%.1f %.1f %.1f\n", a, b, c);
        } else {
            System.out.println(-1);
        }
    }
}
