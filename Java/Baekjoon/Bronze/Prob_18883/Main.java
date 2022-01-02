package Prob_18883;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N M 찍기 - 브론즈 3
 * 
 * 자연수 N, M이 주어졌을 때 1부터 NxM까지 출력 형식대로 출력
 * 
 * 입력
 *  N, M 공백 구분 주어짐 
 *  두 수는 1000보다 작거나 같은 자연수
 * 
 * 출력
 *  총 N개의 줄을 출력
 *  각 줄에는 M개의 정수를 공백 한 칸으로 구분해 출력
 *  1번 줄에는 1 ~ M까지
 *  2번 줄에는 M+1부터 2xM까지
 *  ...
 *  N번 줄에는 (N-1)xM+1부터 NxM까지 출력해야 한다.
 * 
 *  모든 줄의 시작과 끝에는 공백이 있으면 안되고,
 *  모든 줄은 줄바꿈(\n)으로 끝나야 한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        StringBuilder sb = new StringBuilder();

        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(num++);
                if (j != m - 1) {
                    sb.append(" ");
                } else {
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
