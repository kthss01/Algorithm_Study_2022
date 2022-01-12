package Baekjoon.Bronze.Prob1_2897;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 몬스터 트럭 - 브론즈 1
 * 
 * 지도 R행 C열
 *  빌딩 #, 주차 차 X, 빈 주차 공간 .
 * 
 * 차 2행 2열 칸 차지
 * 
 * 주차하기 위해 부숴야하는 차 고려
 *  (주차 하러 가는 길에 부수는 차는 신경 쓰지 않음)
 *  빌딩이 있는 자리에는 주차 X
 * 
 * 입력 
 *  첫 줄 두 정수 R, C (2 <= R, C <= 50)
 *      R은 행의 개수, C는 열의 개수
 *  두번째 줄 R개의 줄에 각각 C개의 문자가 주어짐
 *      이 문자 # X . 로만 이뤄져 있음
 *      X는 항상 영대문자
 * 
 * 출력
 *  다섯 줄
 *  1줄 아무 차도 부수지 않고 주차할 수 있는 공간의 개수
 *  2줄 차 한 대를 부수고 주차할 수 있는 공간의 개수
 *  3줄 차 두 대 ~
 *  4줄 차 세 대 ~
 *  5줄 차 네 대 ~
 */
public class Main {
    static char[][] board;
    static int[] answer = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            if (i == r - 1) {
                continue;
            }
            for (int j = 0; j < c; j++) {
                if (j == c - 1) {
                    continue;
                }

                checkBoard(i, j);
            }
        }

        for (int ans : answer) {
            System.out.println(ans);
        }
    }

    private static void checkBoard(int i, int j) {
        if (board[i][j] == '#') {
            return;
        }

        int cnt = 0;
        boolean isBuilding = false;
        for (int x = i; x < i + 2; x++) {
            for (int y = j; y < j + 2; y++) {
                if (board[x][y] != '.') {
                    if (board[x][y] == '#') {
                        isBuilding = true;
                        break;
                    } 
                    cnt++;
                }
            }
            if (isBuilding) {
                break;
            }
        }
        //System.out.println(i + "," + j + "=" + cnt);

        if (!isBuilding) {
            answer[cnt]++;
        }
    }
}
