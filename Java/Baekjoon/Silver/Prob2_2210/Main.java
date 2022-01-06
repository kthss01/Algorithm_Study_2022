package Baekjoon.Silver.Prob2_2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 숫자판 점프 - 실버 2
 * 
 * 5x5 크기의 숫자판
 * 각각의 칸 숫자 (0 ~ 9) 적혀 있다
 * 이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로
 * 다섯 번 이동하면서, 각 칸에 적혀있는 숫자를 차례대로
 * 붙이면 6자리의 수가 된다.
 * 이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며,
 * 0으로 시작하는 000123과 같은 수로 만들 수 있다.
 * 
 * 숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의
 * 수들의 개수 구하기
 * 
 * 입력
 *  다섯 개의 줄에 다섯 개의 정수로 숫자판이 주어진다.
 * 출력 
 *  첫째 줄에 만들 수 있는 수들의 개수를 출력한다.
 */
public class Main {

    static int[][] board = new int[5][5];
    static Set<Integer> set = new HashSet<>();
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        for (int i = 0; i < 5; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                makeNumber(i, j, 0, 1);
            }
        }

        System.out.println(set.size());
    }

    private static void makeNumber(int x, int y, int num, int cnt) {
        num += Math.pow(10, cnt - 1) * board[x][y];

        if (cnt == 6) {
            set.add(num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x2 = x + dx[i];
            int y2 = y + dy[i];

            if (x2 < 0 || x2 >= 5 || y2 < 0 || y2 >= 5) {
                continue;
            }

            makeNumber(x2, y2, num, cnt + 1);
        }

    }
}
