package Baekjoon.Silver.Prob1_1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 전쟁 - 전투 - 실버 1
 * 
 * N명이 뭉쳐있을 때 N^2 위력을 낼 수 있음
 * 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐있다고 보지 않음
 * 누가 승리할지 확인하기
 * 
 * 입력
 *  첫째 줄 전쟁터의 가로 N, 세로 M (1 <= N,M <= 100)
 *  2 ~ M+1번째 줄 X,Y에 있는 병사들의 옷색 띄어쓰기 없이 주어짐
 *  모든 자리에는 병사가 한 명 있다. (B 파랑, W 흰색)
 * 
 * 출력
 *  병사의 위력의 합과 적국의 병사의 위력의 합 출력
 */
public class Main {
    private static int n;
    private static int m;
    private static char[][] board;
    private static boolean[][] check;
    private static int temp;
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };
    private static int w;
    private static int b;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        m = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());
        board = new char[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        w = 0;
        b = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    dfs(i, j);
                    if (board[i][j] == 'W') {
                        w += temp * temp;
                    } else {
                        b += temp * temp;
                    }
                    temp = 0;
                }
            }
        }
        System.out.println(w + " " + b);
    }

    private static void dfs(int i, int j) {
        if (check[i][j]) {
            return;
        }

        check[i][j] = true;
        temp++;

        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;

            if (x < 0 || x >= n || y < 0 || y >= m) {
                continue;
            }

            if (board[i][j] == board[x][y] && !check[x][y]) {
               dfs(x, y); 
            }
        }
    }
}
