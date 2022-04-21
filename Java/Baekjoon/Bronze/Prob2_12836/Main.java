package Baekjoon.Bronze.Prob2_12836;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가계부 (Easy) - 브론즈 2
 * 
 * 두 가지 동작 처리
 *  생후 p일에 수입/지출 내용 추가
 *  수입은 양수, 지출은 음수의 형태로 입력
 * 
 *  생후 p일부터 q일까지의 잔고가 변화한 값을 구하고 출력
 *  어떤 i에 대해서 생후 i일의 잔고는 음수일 수 있음
 * 
 * 입력
 *  살아온 날 N, 쿼리의 개수 Q (N <= 10^4, Q <= 10^3)
 *  1 p x : 생후 p일에 x 추가 (1 <= p <= N, -2 x 10^9, = x <= 2 x 10^9)
 *  2 p q : 생후 p일부터 q일까지 변화한 양 출력 (1 <= p <= q <= N)
 * 
 * 출력
 *  각 2쿼리에 대해 계산된 값 각 줄 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(token.nextToken());
        int Q = Integer.parseInt(token.nextToken());

        long[] accounts = new long[N + 1];

        for (int i = 0; i < Q; i++) {
            token = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(token.nextToken());

            int p = Integer.parseInt(token.nextToken());

            if (select == 1) {
                accounts[p] += Integer.parseInt(token.nextToken());
            } else {
                int q = Integer.parseInt(token.nextToken());
                long sum = 0;
                for (int j = p; j <= q; j++) {
                    sum += accounts[j];
                }
                sb.append(sum).append("\n");
            }
        }

        System.out.print(sb);
    }
}
