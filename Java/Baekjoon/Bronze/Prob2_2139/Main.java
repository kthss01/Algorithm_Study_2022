package Baekjoon.Bronze.Prob2_2139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나는 너가 살아온 날을 알고 있다. - 브론즈 2
 * 
 * 해당하는 연도의 1월 1일 시작 기준
 * 날짜 주어졌을 때 윤년 계산한 후
 * 주어진 날짜 카운트 하기
 * 
 * 입력
 *  한 줄의 날짜
 *  각 날짜 일, 월, 년이 공백을 두고 주어짐
 *  일과 월 항상 유효, 연도 1700 ~ 2200 사이의 값
 *  0 0 0 입력되면 프로그램 종료
 * 
 * 출력
 *  각 줄에 날짜에 해당하는 날의 수 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while (true) {
            token = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            
            if (d == 0 && m == 0 && y == 0) {
                break;
            }

            boolean isLeap = (y % 4 == 0 && y % 100 != 0) 
                                    || y % 400 == 0;

            int ans = d;

            for (int i = 1; i < m; i++) {
                ans += days[i];
                if (i == 2 && isLeap) {
                    ans++; // 윤년
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
