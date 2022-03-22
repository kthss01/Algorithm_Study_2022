package Baekjoon.Gold.Prob5_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 테트로미노 - 골드 5 
 * 
 * 정사각형은 서로 겹치면 안된다
 * 도형은 모두 연결되어 있어야 한다.
 * 정사각형의 변끼리 연결되어 있어야 한다. 꼭지점과 꼭지점만 맞닿아 있으면 안된다.
 * 
 * 테트리스라고 생각
 * 
 * OOOO 
 * 
 * OO
 * OO
 * 
 * O
 * O
 * OO
 * 
 * O
 * OO
 *  O
 * 
 * OOO
 *  O
 * 
 * 위 모양 있음
 * 
 * 테트로미노 하나 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합
 * 최대로 하기
 * 
 * 회전이나 대칭 가능
 * 
 * 입력
 *  종이의 세로 크기 N, 가로 크기 M (4 <= N, M <= 500)
 *  주어지는 수 1000 넘지 않는 자연수
 * 
 * 출력
 *  최댓값 출력
 * 
 * -> 오랜시간 풀지 못해서 풀이보고 진행 DFS로 푸는거라고 함
 */

public class Main {

    private static int n, m, a[][], result;
    private static boolean check[][];
    private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {-1, 1, 0, 0};

    private static int ex[][] = {
        {0,0,0,1}, {0,1,2,1}, {0,0,0,-1}, {0,-1,0,1}
    };
    private static int ey[][] = {
        {0,1,2,1}, {0,0,0,1}, {0,1,2,1}, {0,1,1,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n+1][m+1];
        check = new boolean[n+1][m+1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // compute
        // 2차원 배열 각각의 원소에서 검사 수행
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // DFS
                
                // 방문했던 점 또 방문해야 함
                // 들어가기전 체크 후 끝났을 때 체크 해제
                check[i][j] = true;

                dfs(i, j, a[i][j], 1);

                // 길이로 재귀를 중단시키기 때문에
                // 수행횟수는 4 * 3 * 3, 한점에서 최대 36번 수행
                check[i][j] = false;

                // ㅏ 모양 검사
                check_exshape(i, j);
            }
        }

        System.out.println(result);
    }

    public static void dfs(int x, int y, int sum_value, int length) {
        // 길이가 4 이상이면 종료
        if (length >= 4) {
            result = Math.max(result, sum_value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // check
            if (nx < 1 || nx > n || ny < 1 || ny > m) {
                continue;
            }

            if (check[nx][ny] == false) {
                check[nx][ny] = true;

                dfs(nx, ny, sum_value + a[nx][ny], length + 1);

                check[nx][ny] = false;
            }
        }
    }

    public static void check_exshape(int x, int y) {
        for (int i = 0; i < 4; i++) {
            boolean isOut = false;
            int sum_value = 0;

            for (int j = 0; j < 4; j++) {
                int nx = x + ex[i][j];
                int ny = y + ey[i][j];

                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    isOut = true;
                    break;
                } else {
                    sum_value += a[nx][ny];
                }   
            }

            if(!isOut) {
                result = Math.max(result, sum_value);
            }
        }
    }
}