package Baekjoon.Silver.Prob5_10469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * 사이 나쁜 여왕들 - 실버 5
 * 
 * 체스판 8x8 위에 여덟 여왕을 둘 때 
 * 아무도 서로 공격할 수 없도록 배치 하기
 * 
 * 체스판과 여왕의 배치가 주어질 때
 * 해당 배치가 올바른 해법인지 아닌지 판단하기
 * 
 * 입력
 *  하나의 체스판 8줄 걸쳐 줄마다 8개의 문자로 나타냄
 *  . * 이며 . 빈칸, * 여왕이 있음을 나타냄
 * 
 * 출력
 *  올바른 해법일 경우 valid
 *  아닌 경우 invalid 출력
 */
public class Main {
    final static int MAX_NUM = 8;
    private static char[][] board = new char[MAX_NUM][MAX_NUM];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < MAX_NUM; i++) {
            board[i] = br.readLine().toCharArray();
        }

        boolean isValid = true;

        for (int i = 0; i < MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                if (board[i][j] == '*') {
                    isValid = checkValid(i, j);
                }
            }
            if (!isValid) {
                break;
            }            
        }

        if (isValid) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }

    private static boolean checkValid(int x, int y) {
        boolean result = true;

        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int i = 0; i < 8; i++) {
            // 각 방향으로 최대한 이동
            for (int j = 1; j < MAX_NUM; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (nx < 0 || nx >= MAX_NUM || ny < 0 || ny >= MAX_NUM) {
                    break;
                }

                if (board[nx][ny] == '*') {
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }

        return result;
    }
}
