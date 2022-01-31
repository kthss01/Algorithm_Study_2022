package Baekjoon.Silver.Prob5_1380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 귀걸이 - 실버 5
 * 
 * 귀걸이를 압수함 
 *  압수한 귀걸이 뒤쪽에 여학생 번호와 임의로 'A', 'B를 적음
 * 
 * 시간이 지나면 귀걸이를 돌려받음
 * 근데 하나를 끝내 찾지 못함
 * 귀걸이를 받지 못해 화난 소녀의 이름 찾기
 * 
 * 입력
 *  번호를 가진 시나리오
 *  1부터 순서대로 증가
 *      여학생의 수 n (1 ~ 100)
 *      n줄 여학생의 이름 (최대 60자)
 *      2n - 1 줄에 여학생 번호와 'A', 'B'가 공백 구분 주어짐
 *      여학생 번호 최대 2번 등장
 *      두번째로 등장할때 첫번째와 다른 'A', 'B' 가 적힘
 *      번호가 처음 등장하는 것은 압수되었음을
 *      두 번째로 등장하는 것은 돌려받았음을 의미
 * '0'을 마지막 줄로 하여 입력 종료
 * '0' 처리 x
 * 
 * 출력
 *  시나리오 번호와 귀걸이를 돌려받지 못한 여학생의 이름
 *  공백 구분하여 한 줄씩 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        int t = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            String[] girls = new String[n];
            for (int i = 0; i < n; i++) {
                girls[i] = br.readLine();
            }

            int[] check = new int[n];
            for (int i = 0; i < 2 * n - 1; i++) {
                token = new StringTokenizer(br.readLine());

                int girl = Integer.parseInt(token.nextToken());
                char earring = token.nextToken().charAt(0);

                if (earring == 'A') {
                    check[girl - 1]++;
                } else {
                    check[girl - 1]--;
                }
            }

            int find = n;
            for (int i = 0; i < n; i++) {
                 if (check[i] != 0) {
                    find = i;
                    break;
                 }
                 
            }

            sb.append(String.format("%d %s\n", t++, girls[find]));
        }

        System.out.print(sb);
    }
}
