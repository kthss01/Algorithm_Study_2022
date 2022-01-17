package Baekjoon.Silver.Prob3_2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열 - 실버 3
 * 
 * 매일 측정한 온도가 정수의 수열로 주어졌을 때,
 * 연속적인 며칠 동안의 온도의 합이 가장 큰 값 계산하기
 * 
 * 입력
 *  두 개의 정수 N과 한 개의 공백을 사이에 두고 순서대로 주어짐
 *  첫 번째 정수 N은 온도를 측정한 전체 날짜의 수
 *      N은 2 이상 100,000 이하
 *  두 번째 정수 K는 합을 구하기 위한 연속적인 날짜의 수
 *      K 1과 N 사이의 정수
 *  둘째 줄에는 매일 측정한 온도를 나타내는 N개의 정수가
 *  빈칸을 사이에 두고 주어진다.
 *  이 수들은 모두 -100 이상 100 이하
 * 
 * 출력
 *  입력되는 온도의 수열에서 연속적인 K일의 온도의 합이
 *  최대가 되는 값을 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                sum += arr[i];

                if (i == k - 1) {
                    maxNum = sum;
                }
            } else {
                sum -= arr[i-k];
                sum += arr[i];

                maxNum = Math.max(maxNum, sum);
            }
        }

        System.out.println(maxNum);
    }
}
