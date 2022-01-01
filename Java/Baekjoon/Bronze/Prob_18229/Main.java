package Prob_18229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내가 살게, 아냐 내가 살게 - 브론즈 1
 * 
 * N명일 서로 결제하겠다며 카드를 내밀고 있고
 * 사람들과 점원의 거리는 K이다
 * 처음으로 손을 K이상 뻗은 사람이 결제하게 된다
 * 
 * A라는 2차원 배열이 주어지고
 * 1번 사람이 A1,1만큼 2번 A2,1 ... N번 사람
 * 1번 사람이 A1,2 2번 A2,2 ... 
 * 이런 순으로 M번까지 뻗게 된다
 * 
 * 가장 먼저 K이상 손을 뻗으면 그 사람이 결제하며 상황 종료
 * 항상 손을 K이상 뻗는 사람이 존재하게 입력 주어짐
 * 결제하게 되는 사람은 누구이며 그 사람이 뻗은 횟수는?
 * 
 * 입력
 *  N, M (1 ~ 100) K (1 ~ 10,000,000)
 *  둘째 줄부터 N개의 각 줄 M개의 정수 공백 구분
 *  Ai,j (1 ~ 10,000,000)
 * 
 * 출력
 *  결제한 사람이 누구인지, 뻗은 횟수 공백 구분 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[][] board = new int[n][m];
        int[] players = new int[n];
        
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(token.nextToken());
            }
            players[i] = 0;
        }
        
        int winner = 1;
        int count = 0;
        while (true) {
            boolean isOver = false;
            for (int i = 0; i < players.length; i++) {
                players[i] += board[i][count];
                if (players[i] >= k) {
                    isOver = true;
                    winner = i + 1;
                    break;
                }
            }
            count++;
            if (isOver) {
                break;
            }
        }

        System.out.println(winner + " " + count);
    }    
}
