package Prob2_18228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 팽귄추락대책위원회 - 브론즈 2
 * 
 * N개의 얼음이 1 ~ N 번호로 매겨져 있고
 * 게임은 얼음 1 ~ N까지 순서대로 일렬로 나열된 공간에서 진행
 * 펭귄 한 마리 임의의 얼음 K위에 위치
 * 몇 개의 얼음을 깨뜨려서 펭귄을 떨어뜨리는 것이 목적
 * 단, 펭귄이 밟고 있는 얼음은 깨뜨릴 수 없음
 * 각 얼음은 서로 다른 강도를 가지고 있어
 * 얼음 i 를 깨뜨리는데 Ai만큼의 힘이 필요
 * 양옆으로 인접해 있는 얼음들을 하나의 그룹으로 봤을 때,
 * 그룹의 끝이 얼음1 또는 N을 포함하지 않는다면
 * 이 얼음 그룹은 아래로 추락하게 됨
 * 
 * 펭귄을 떨어뜨릴 수 있는 최소 힘 구하기
 * 
 * 입력
 *  얼음의 개수 N (3 ~ 200,000)
 *  i번째 얼음을 깨뜨리는 데 드는 힘 Ai (1 ~ Ai <= 1,000,000,000)
 *  예외적으로 펭귄이 위치한 곳은 -1로 표시
 *  펭귄이 얼음1 또는 N에 위치하는 경우는 존재 x
 * 
 * 출력
 *  펭귄을 떨어뜨릴 수 있는 최소 힘을 나타내는 정수 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());

        int left = 1000000000;
        int right = 1000000000;
        boolean findLeft = true;
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(token.nextToken());
            if (num == -1) {
                findLeft = false;
            } else if (findLeft) {
                left = Math.min(left, num);
            } else {
                right = Math.min(right, num);
            }
        }

        System.out.println(left + right);
    }
}
