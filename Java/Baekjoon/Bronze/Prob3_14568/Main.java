package Baekjoon.Bronze.Prob3_14568;

import java.util.Scanner;

/**
 * 2017 연세대학교 프로그래밍 경시대회 - 브론즈 3
 * 
 * N개의 사탕을 나눠 가지기
 *  남는 사탕은 없어야 함
 *  남규는 영훈이보다 2개 이상 많은 사탕을 가져야 함
 *  셋 중 사탕을 0개 받는 사람은 없어야 함
 *  택희가 받는 사탕의 수는 홀수개가 되어서는 안 된다.
 * 
 * 사탕의 개수 N이 주어지면, 
 * 사탕을 세 사람에게 분배하는 서로 다른 경우의 수 구하기
 * 
 * 입력
 *  사탕 개수 N (1 <= N <= 100)
 * 
 * 출력
 *  A, B, C라 할때 A, B, C 순서쌍의 수 구하기
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // a 택희 b 영훈 c 남규

        int ans = 0;
        for (int a = 1; a <= n; a++) {
            if (a % 2 == 1) {
                continue;
            }
            for (int b = 1; b <= n; b++) {
                int c = n - a - b;
                if (c < 0 || b + 2 > c) {
                    continue;
                }
                ans++;
            }
        }
        System.out.println(ans);

        sc.close();
    }
}
