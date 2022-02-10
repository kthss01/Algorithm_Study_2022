package Baekjoon.Gold.Prob5_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 용액 - 골드 5
 * 
 * 산성 1 ~ 1,000,000,000
 * 알칼리 -1 ~ -1,000,000,000
 * 
 * 같은 양의 두 용액을 혼합한 용액의 특성값 
 * 혼합에 사용된 각 용액의 특성값의 합
 * 0에 가까운 특성값을 만들려고 함
 * 두 용액 찾기
 * 
 * 입력
 *  전체 용액의 수 N (2 ~ 100,000)
 *  빈칸 구분 용액 (-1,000,000,000 ~ 1,000,000,000)
 *  N개의 용액들의 특성값 모두 다르고, 
 *  산성 용액만으로나 알칼리 용액만으로 입력이 주어지는 경우도 있음
 * 
 * 출력
 *  0에 가까운 두 용액의 특성값 출력
 *  오름차순 출력
 *  특성값이 0에 가장 가까운 용액을 만들어내는 경우
 *      2개 이상일 경우 아무거나 하나 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);

        int dist = Integer.MAX_VALUE;
        int[] ans = new int[2];
        
        // for (int i = 0; i < n; i++) {
        //     int s = i + 1;
        //     int e = n - 1;

        //     while (s <= e) {
        //         int mid = (s + e) / 2;
        //         int sum = arr[i] + arr[mid];

        //         if (Math.abs(sum) < dist) {
        //             dist = Math.abs(sum);
        //             ans[0] = arr[i];
        //             ans[1] = arr[mid];
        //         }

        //         if (sum < 0) {
        //             s = mid + 1;
        //         } else {
        //             e = mid - 1;
        //         }
        //     }
        // }

        int s = 0;
        int e = n - 1;
        while (s < e) {
            int sum = arr[s] + arr[e];

            if (Math.abs(sum) < dist) {
                dist = Math.abs(sum);
                ans[0] = arr[s];
                ans[1] = arr[e];
            }

            if (sum == 0) {
                break;
            } else if (sum > 0) {
                e--;
            } else {
                s++;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
