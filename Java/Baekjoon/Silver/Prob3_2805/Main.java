package Baekjoon.Silver.Prob3_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나무 자르기 - 실버 3
 * 
 * 나무 M미터 필요
 * 목재절단기 다음과 같이 동작
 *  절단기에 높이 H를 지정
 *  높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라감
 *  그 다음, 한 줄에 연속해 있는 모든 나무 절단
 *  높이가 H보다 큰 나무 H 위의 부분이 잘림
 *      낮은 나무는 안잘림
 *  
 *  ex) 20, 15, 10, 17
 *      15로 지정하면
 *    -> 15, 15, 10, 15
 *        길이 5, 2 나무 집에 가지고 갈 수 있음 (총 7)
 *  절단기에 설정할 수 있는 높이 양의 정수 또는 0
 * 
 * 나무 필요한 만큼만 가지고 가려고함
 * 적어도 M미터의 나무를 집에 가져가기 위해서 
 * 절단기에 설정할 수 있는 높이의 최댓값 구하기
 * 
 * 입력
 *  나무의 수 N, 가지고 가려는 나무의 길이 M 
 *      1 ~ N ~ 1,000,000  1 ~ M ~ 2,000,000,000
 *  나무의 높이 
 *      나무의 높이의 합은 항상 M보다 크거나 같음
 *  높이 1,000,000,000보다 작거나 같은 양의 정수 또는 0
 * 
 * 출력
 *  적어도 M미터의 나무를 집에 가져가기 위해서
 *      절단기에 설정할 수 있는 높이의 최댓값 출력
 */
public class Main {
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());

        trees = new int[n];
        // int minHeight = Integer.MAX_VALUE;
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(token.nextToken());
            // minHeight = Math.min(minHeight, trees[i]);
            maxHeight = Math.max(maxHeight, trees[i]);
        }
        int s = 0;
        int e = maxHeight;

        while (s < e) {
            int mid = (s + e) / 2;
            long sum = computeTree(mid);

            if (sum < m) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(s - 1);
    }

    private static long computeTree(int height) {
        long ans = 0;
        for (int tree : trees) {
            ans += Math.max(0, tree - height);
        }
        return ans;
    }
}
