package Baekjoon.Bronze.Prob3_9437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 사라진 페이지 찾기 - 브론즈 3
 * 
 * 종이 양면 반으로 나눠서 사용하고 있음
 * ex)
 *  1,2,11,12 한장
 *  3,4,9,10 한장
 *  5,6,7,8 한장
 * 
 * 2쪽이 인쇄된 종이 버리면 나머지 페이지 1,11,12
 * 
 * 한쪽 페이지만으로 나머지 페이지 찾기
 * 
 * 입력
 *  각 테스트 케이스 두 가지 정수 N, P
 *      4의 배수 N (4 <= N <= 1000) 전체 페이지 수
 *      P (1 <= P <= N) 선택된 한 페이지
 *  입력의 마지막은 0만 주어짐
 * 
 * 출력
 *  각 테스트 케이스에 대해 사라진 페이지들을 오름차순 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        while (true) {
            token = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(token.nextToken());

            if (n == 0) {
                break;
            }

            int p = Integer.parseInt(token.nextToken());
            int p2 = p % 2 == 0 ? p - 1 : p + 1;

            int[] arr = new int[4];
            arr[0] = p;
            arr[1] = n - p + 1;
            arr[2] = p2;
            arr[3] = n - p2 + 1;
            
            Arrays.sort(arr);

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == p) {
                    continue;
                }
                sb.append(arr[i]);
                if (i != arr.length - 1) {
                    sb.append(" ");
                } else {
                    sb.append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
