package Baekjoon.Bronze.Prob2_1362;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 펫 - 브론즈 2
 * 
 * 실제 체중 적정 체중 1/2배 초과하면서
 * 적정 체주으이 2배미만이라면 행복
 * 실제 체중 0 이하일 경우 사망
 * 그 외의 경우 슬픔
 * 
 * 콘솔을 통해 두 가지 적용 가능
 *  'E'와 숫자를 입력해 운동 시킬 수 있음
 *      입력된 숫자(n)만큼의 시간이 지나면 실제 체중 n 감소
 *  'F'와 숫자를 입력해 먹이 줄 수 있음
 *      입력된 숫자(n)만큼 펫에게 먹이를 주면 펫의 실제 체중 증가
 * 
 * 각 작용에 입력할 수 있는 숫자 1 ~ 999
 * 매 작용이 끝날 때마다 자신의 상태 표시
 * 중간에 죽는다면 이후 작용 모두 무시
 * 
 * 입력
 *  번호를 가진 시나리오들로 구성
 *  시나리오 1번부터 시작되며 1씩 증가
 *  적정 체중(o)와 실제 체중(w)가 한 줄에 입력됨으로써
 *  시나리오 시작 (10 <= o, w <= 1000)
 *  그 다음 줄부터 펫에 가할 작용이 한 줄에 하나씩 주어지며
 *  "# 0" 을 마지막 줄로하여 시나리오 종료
 *  "# 0" 처리 x
 *  펫에게 가할 각 작용은 'E' 또는 'F'로 시작하며
 *  공백을 두고 숫자 n (1 ~ n ~ 999)이 주어짐
 *  모든 시나리오가 끝나면 "0 0" 입력되며 "0 0" 처리 x
 *
 * 출력
 *  각 시나리오에 대하여,
 *  시나리오 번호와 모든 작용이 완료된 후 펫의 상태 공백 구분
 *  한 줄씩 출력
 *  행복 => ":-)"
 *  슬픔 => ":-("
 *  사망 => "RIP"
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        String[] emotions = { ":-)", ":-(", "RIP" };

        int cnt = 1;
        while (true) {
            token = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(token.nextToken());
            int w = Integer.parseInt(token.nextToken());

            if (o == 0 && w == 0) {
                break;
            }

            sb.append(cnt++ + " ");

            boolean isDead = false;
            while (true) {
                token = new StringTokenizer(br.readLine());

                String state = token.nextToken();
                int n = Integer.parseInt(token.nextToken());

                if (state.equals("#") && n == 0) {
                    if (isDead) {
                        break;
                    } else if (w * 2 > o && w < o * 2) {
                        sb.append(emotions[0]);
                    } else {
                        sb.append(emotions[1]);
                    }
                    break;
                }

                if (state.equals("E")) {
                    w -= n;
                } else if (state.equals("F")) {
                    w += n;
                }

                if (w <= 0) {
                    sb.append(emotions[2]);
                    isDead = true;
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
