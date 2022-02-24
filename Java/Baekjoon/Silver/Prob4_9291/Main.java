package Baekjoon.Silver.Prob4_9291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스도쿠 채점 - 실버4
 * 
 * 스도쿠 일본어로 수독을 읽는 것
 * 미국에서 유명한 일본의 한 퍼즐 이름
 * 
 * 9x9 격자판에 다음 조건을 만족하여 수를 채워 넣는 게임
 *  각 정수 1-9는 각 행에 정확히 한 번씩 등장
 *  각 정수 1-9는 각 열에 정확히 한 번씩 등장
 *  각 정수 1-9는 각 작은 3x3 정사각형에 정확히 한 번씩 등장
 * 
 * 다 채워진 스도쿠 판이 올바른 답인지 판별하기
 * 
 * 입력
 *  첫 줄 테스트 케이스 개수
 *  각 테스트 케이스 9개의 줄
 *      각 줄에는 9개의 정수가 공백 구분
 *      각 정수는 1 ~ 9
 *  테스트 케이스의 사이에 빈줄이 하나 있음
 *  테스트 케이스의 개수 100개 넘지 않음
 * 
 * 출력
 *  각 테스트 케이스에 걸쳐 "Case x:" 출력 후
 *  공백 한 칸 뒤에 풀이가 올바르면 CORRECT
 *  아니면 INCORRECT 출력
 *  x 테스트 케이스 번호 1부터 시작
 * 
 * 하나 체크할 때 행, 열, 칸에 대해서 다 체크해야할 거 같음
 */

public class Main {
    enum CheckType {
        
    }

    static int[][] arr;
    static boolean[][][] check;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb.append(String.format("Case %d: ", i + 1));
            
            arr = new int[9][9];
            for (int j = 0; j < 9; j++) {
                token = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    arr[j][k] = Integer.parseInt(token.nextToken());
                }
            }

            if (isSudoku()) {
                sb.append("CORRECT");
            } else {
                sb.append("INCORRECT");
            }
            sb.append("\n");

            if (i != t - 1) {
                br.readLine();
            }
        }

        System.out.print(sb);
    }

    private static boolean isSudoku() {

        // 행 체크
        for (int i = 0; i < 9; i++) {
            check = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (!check[arr[i][j] - 1]) {
                    check[arr[i][j] - 1] = true;
                } else {
                    return false;
                }
            }
        }

        // 열 체크
        for (int i = 0; i < 9; i++) {
            check = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (!check[arr[i][j] - 1]) {
                    check[arr[i][j] - 1] = true;
                } else {
                    return false;
                }
            }
        }

        // 칸 체크
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                check = new boolean[9];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int x = i * 3 + k;
                        int y = j * 3 + l;
                        if (!check[arr[x][y] - 1]) {
                            check[arr[x][y] - 1] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
