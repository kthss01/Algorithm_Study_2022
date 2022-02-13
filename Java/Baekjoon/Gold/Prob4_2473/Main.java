package Baekjoon.Gold.Prob4_2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 세 용액 - 골드 4
 * 
 * 산성 1 ~ 1,000,000,000
 * 알칼리성 -1 ~ -1,000,000,000
 * 
 * 세 가지 용액 합한게 0에 가장 가까운 용액 찾기
 * 
 * 입력
 *  전체 용액의 수 N, 3 ~ 5000
 *  용액의 특성값을 나타내는 N개의 정수 빈칸
 *      -1,000,000,000 ~ 1,000,000,000
 * 
 * 출력
 *  0에 가장 가까운 용액을 만들어내는 세 용액의 특성값 출력
 *  오름차순 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        long[] ans = new long[3];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(token.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            int s = 0;
            int e = n - 1;

            while (s < i && i < e) {
                long sum = arr[s] + arr[i] + arr[e];

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    ans[0] = arr[s];
                    ans[1] = arr[i];
                    ans[2] = arr[e];
                }

                if (sum == 0) {
                    break;
                } else if (sum < 0) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.println(
            String.format("%d %d %d", ans[0], ans[1], ans[2]));
    }
}
