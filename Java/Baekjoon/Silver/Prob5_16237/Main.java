package Baekjoon.Silver.Prob5_16237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이삿짐센터 - 실버5
 * 
 * 무게가 1kg인 물건 A개
 * 2kg B
 * 3kg C
 * 4kg D
 * 5kg E
 * 
 * 바구니에 최대 5kg까지 물건을 담을 수 있음
 * 모든 물건을 담는데 필요한 바구니 개수 최소
 * 
 * 무게의합 5kg 넘을 수 없음
 * 물건의 무게가 주어졌을 대
 * 모든 물건을 담는데 필요한 바구니 개수의 최솟값 구하기
 * 
 * 입력
 *  A, B, C, D, E (0 <= A,B,C,D,E <= 1,000)
 * 출력
 *  최솟값 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int d = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());

        // 이 방법 한계가 있을 듯 dp로 가자
        int ans = 0;
        ans += e;
        ans += d; 
        if (a != 0 && a >= d) {
            a -= d;
        } 
        ans += c;
        int t = b - c;
        if (b != 0 && b >= c) {
            b -= t;
        }
        if (a != 0 && a >= c - t) {
            a -= c - t;
        }
        ans += b;
        

    }
}
