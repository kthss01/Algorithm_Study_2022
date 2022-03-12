package Baekjoon.Silver.Prob5_5046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 전국 대학생 프로그래밍 대회 동아리 연합 - 실버 5
 * 
 * 회원들이 머무를 호텔 찾기 
 * 되도록 싼 호텔 찾아야 함
 * 여행의 총 비용 예산 초과하면 안됨
 * 모든 회원은 같은 호텔에 머물러야 함
 * 
 * 입력
 *  첫째 줄 
 *      참가자의 수 (1 <= N <= 200), 
 *      예산 (1 <= B <= 500000), 
 *      호텔의 수 (1 <= H <= 18),
 *      고를 수 있는 주의 개수 (1 <= W <= 13)
 * 
 *  각 호텔의 정보 주어짐
 *  호텔의 정보 두 줄
 *      그 호텔의 일인당 숙박비용 (1 <= p <= 10000)
 *      i번째 주에 투숙 가능한 인원 (0 <= a <= 1000)
 * 
 * 출력
 *  대회를 개최할 수 있으면 최소 비용 출력, 없으면 "stay home" 출력
 * 
 * 뭔가 잘못한게 있는지 자꾸 틀림
 * 깔끔하게 정리해서 풀어보자
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int h = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());

        int cost = Integer.MAX_VALUE;

        for (int i = 0; i < h; i++) {
            int p = Integer.parseInt(br.readLine());
            int hotelCost = p * n;

            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                int a = Integer.parseInt(token.nextToken());
                if (a >= n && hotelCost <= b) {
                    cost = Math.min(cost, hotelCost);
                }
            }
        }

        if (cost == Integer.MAX_VALUE) {
            System.out.println("stay home");
        } else {
            System.out.println(cost);
        }
    }
}
