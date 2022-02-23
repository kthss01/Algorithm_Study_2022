package Baekjoon.Silver.Prob5_9237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 이장님 초대 - 실버 5
 * 
 * 나무 묘목 n개
 * 묘목 하나 심는데 걸리는 시간 1일
 * 각 묘목이 다 자라는데 며칠이 걸리는지 알고 있음
 * 모든 나무가 완전히 자란 다음 날 이장님 초대 하려고 함
 * 나무 심는 순서를 신중하게 골라
 * 이장님을 최대한 빨리 초대하려고 함
 * 이장님을 며칠에 초대할 수 있는가?
 * 
 * 입력
 *  첫째 줄 묘목의 수 N (1 <= N <= 100,000)
 *  각 나무가 다 자라는데 며칠이 걸리는지를 나타낸 ti
 *      (1 <= ti <= 1,000,000)
 * 출력
 *  며칠에 이장님을 초대할 수 있는지 출력
 *  답이 여러 가지인 경우 가장 작은 값 출력
 *  묘목을 구입한 날이 1일
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr, Comparator.reverseOrder());  

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int temp = arr[i] + i + 1;
            ans = Math.max(temp, ans);
        }

        ans++; // 다 자라고 난 다음날 초대라 +1
        System.out.println(ans);
    }
}
