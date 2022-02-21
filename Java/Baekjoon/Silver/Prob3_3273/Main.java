package Baekjoon.Silver.Prob3_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 수의 합 - 실버 3
 * 
 * n개의 서로 다른 양의 정수 a1, ... , an으로 이루어진 수열이 있다.
 * ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
 * 자연수 x가 주어졌을 때, ai + aj = x (1 <= i < j <= n) 을
 * 만족하는 (ai, aj)쌍의 수를 구하기
 * 
 * 입력
 *  수열의 크기 n
 *  다음 줄에 수열에 포함되는 수 주어짐
 *  x (1 <= n <= 100000, 1 <= x <= 2000000)
 * 출력
 *  문제의 조건을 만족하는 쌍의 개수 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        boolean[] check = new boolean[2000001];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
            check[arr[i]] = true;
        }

        int x = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = x - arr[i];
            if (num > 0 && check[num]) {
                ans++;
            }
        }
        System.out.println(ans / 2);
    }
}
