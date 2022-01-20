package Baekjoon.Bronze.Prob2_1075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 나누기 - 브론즈 2
 * 
 * 두 정수 N과 F
 * 정수 N의 가장 뒤 두 자리를 적절히 바꿔서 N을 F로 나누어
 * 떨어지게 만들려고 함
 * 만약 가능한 것이 여러 가지이면 뒤 두 자리를 가능하면 작게
 * 만들려고 함
 * 
 * ex)
 *  N = 275 F = 5 답 00
 *  N = 1021 F = 11 답 01
 *      1001 이 11로 나누어 떨어지기 때문
 * 
 * 입력
 *  1줄 N 100 ~ 2,000,000,000
 *  2줄 F 100 보다 작거나 같은 자연수
 * 
 * 출력
 *  마지막 두 자리 모두 출력
 *  한자리이면 앞에 0을 추가
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        int temp = n / 100 * 100;
        int ans = 0;
        for (int i = 0; i <= f; i++) {
            if ((temp + i) % f == 0) {
                ans = i;
                break;
            }
        }
        System.out.println(ans >= 10 ? ans 
                        : String.format("%02d", ans));
    }
}
