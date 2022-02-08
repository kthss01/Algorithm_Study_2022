package Baekjoon.Gold.Prob5_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 용액 - 골드 5
 * 
 * 산성용액 1 ~ 1,000,000,000
 * 알칼리성용액 -1 ~ -1,000,000,000
 * 
 * 같은 양의 두 용액을 혼합한 용ㅇ액의 특성값은
 * 혼합에 사용된 각 용액의 특성값의 합으로 정의
 * 같은 양의 두 용액을 혼합하여 
 * 특성값이 0에 가장 가까운 용액을 만들려고 함
 * 
 * ex)
 *  [-99, -2, -1, 4, 98]
 *  -99, 98 용액 혼합하면 특성값 -1인 용액 만들 수 있고
 *  이 용액의 특성값이 0에 가장 가까운 용액
 *  참고로, 두 종류의 알칼리성 용액만으로나
 *  두 종류의 산성 용액만으로 특성값이 0에 가장 가까운
 *  혼합 용액을 만드는 경우도 존재
 * 
 * 산성 용액과 알칼리성 용액의 특성값이 정렬된 순서로
 * 주어졌을 때 특성값이 0에 가장 가까운 용액을 만들어내는
 * 두 용액 찾기
 * 
 * 입력
 *  전체 용액의 수 N 2 ~ 100,000
 *  용액의 특성값을 나타내는 N개의 정수 빈칸 사이 두고 오름차순 입력
 *  이 수들 모두 -1,000,000,000 이상 1,000,000,000 이하
 *  N개의 용액들의 특성값 모두 서로 다르고
 *  산성 용액만으로나 알칼리성 용액만으로 입력이 주어지는 경우도 있을 수 있음
 * 
 * 출력
 *  특성값이 0에 가장 가까운 용액 만들어내는 두 용액의 특성값 출력
 *  출력해야 하는 두 용액은 특성값의 오름차순으로 출력
 *  특성값이 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우에는
 *  그 중 아무것이나 하나 출력
 * 
 * 시간초과남 투 포인터 써야할거 같은데 
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int n1 = 0;
        int n2 = 0;
        int dist = 1000000001;
        for (int i = 0; i < n - 1; i++) {
            n1 = arr[i];

            int low = i + 1;
            int high = n - 1;
            int mid = (low + high) / 2;

            if (Math.abs(n1 + arr[mid]) < dist) {
                
            }
        }
        System.out.println();
    }
}
