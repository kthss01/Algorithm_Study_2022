package Baekjoon.Silver.Prob5_2435;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 기상청 인턴 신현수 - 실버 5
 * 
 * 측정한 온도가 어떤 정수의 수열로 주어졌을 때,
 * 연속적인 며칠 동안의 온도의 합이 가장 큰 값 구하기
 * N일 동안 측정한 온도가 순서대로 주어졌을 때,
 * 연속적인 K일 동안의 온도의 합이 가장 큰 값 구하기
 * 
 * 입력
 *  두 개의 정수 N, K 공백 사이에 두고 주어짐
 *  N은 온도를 측정한 전체 날짜의 수
 *      N 2 ~ 100
 *  K는 합을 구하기 위한 연속적인 날짜의 수
 *      K 1 ~ N
 *  매일 측정한 온도를 나타내는 N개의 정수
 *      빈칸을 사이에 두고 주어짐
 *      -100 ~ 100
 * 
 * 출력
 *  온도의 수열에서 연속적인 K일의 온도의 합이 최대가 되는 값 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[] arr = new int[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
