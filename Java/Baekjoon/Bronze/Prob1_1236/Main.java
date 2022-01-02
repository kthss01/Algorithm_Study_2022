import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 성 지키기 - 브론즈 1
 * 
 * 직사각형 모양의 성
 * 모든 행과 모든 열에 한 명 이상의 경비원이 있어야함
 * 성의 크기와 경비원이 어디있는지 주어졌을 떄,
 * 몇 명의 경비원을 최소로 추가해야하는지 구하기
 * 
 * 입력
 *  성의 세로 N 가로 M 
 *      N, M은 50보다 작거나 같은 자연수
 *  둘째 줄부터 N개의 줄에는 성의 상태 주어짐
 *      . 빈칸, X는 경비원이 있는 칸
 * 
 * 출력
 *  추가해야 하는 경비원의 최솟값 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        boolean[] rowCheck = new boolean[n];
        boolean[] colCheck = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    rowCheck[i] = true;
                    colCheck[j] = true;
                }
            }
        }

        int rowCnt = 0;
        for (int i = 0; i < n; i++) {
            if (!rowCheck[i]) {
                rowCnt++;
            }
        }
        int colCnt = 0;
        for (int i = 0; i < m; i++) {
            if (!colCheck[i]) {
                colCnt++;
            }
        }
        System.out.println(Math.max(rowCnt, colCnt));
    }
}
