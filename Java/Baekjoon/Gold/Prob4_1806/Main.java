package Baekjoon.Gold.Prob4_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분합 - 골드 4
 * 
 * 10000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다.
 * 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상 되는 것
 * 중 가장 짧은 것의 길이 구하기
 * 
 * 입력
 *  첫째 줄 N (10 <= N < 100,000) S (0 <= S <= 100,000,000)
 *  둘째 줄 수열
 *      수열의 각 원소 공백 구분
 *      10,000 이하의 자연수
 * 
 * 출력
 *  첫째 줄에 구하고자 하는 최소의 길이 출력
 *  만일 그러한 합을 만드는 것이 불가능하다면 0 출력
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int s = Integer.parseInt(token.nextToken());

        int[] arr = new int[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int start = 0;
        int end = 0;
        int len = n + 1;
        long sum = 0;

        while (true) {
            if (sum < s) {
                if (end == arr.length) {
                    break;
                }
                sum += arr[end++];
                continue;
            }

            if (sum >= s) {
                len = Math.min(len, end - start);
            }

            sum -= arr[start++];
        }

        System.out.println(len == n + 1 ? 0 : len);
    }
}
