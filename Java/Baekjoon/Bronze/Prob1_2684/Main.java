package Baekjoon.Bronze.Prob1_2684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 동전 게임 - 브론즈 1
 * 
 * 3-동전수열
 *  앞 뒤 앞과 같은 수열 중 하나 선택
 *  ex) 8가지 (뒤뒤뒤, 뒤뒤앞, 뒤앞뒤, 뒤앞앞, 
 *              앞뒤뒤, 앞뒤앞, 앞앞뒤, 앞앞앞)
 * 
 * 심판 동전 1개를 40번 던짐
 * 그 다음 심판은 동전이 앞인지 뒤인지를 던진 순서대로 종이에 적음
 * 그 다음 3-동전수열이 각각 몇 번씩 나왔는지 기록
 * 가장 많이 나온 수열을 선택한 사람이 이김
 * 
 * 동전 40번 던진 결과가 주어졌을 때,
 * 3-동전수열이 각각 몇 번 나왔는지를 출력하기
 * ex) 40개의 동전이 모두 앞면일 경우
 * 앞앞앞은 38번 나타남
 * 
 * 입력
 *  테스트 케이스의 개수 P (1 ~ 1000)
 *  각 테스트 케이스 한 줄
 *  동전을 40번 던진 결과가 주어짐
 *  앞면 H, 뒷면 T로 표현
 * 
 * 출력
 *  각 테스트 케이스마다 3-동전수열이 몇 번 나타났는지 출력
 *  뒤뒤뒤, 뒤뒤앞, 뒤앞뒤, 뒤앞앞, 앞뒤뒤, 앞뒤앞, 앞앞뒤, 앞앞앞
 *  순서대로 공백 구분해서 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p; i++) {
            String coins = br.readLine();

            Map<String, Integer> map = new HashMap<>();
            String[] kinds = { "TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH" };
            for (String kind : kinds) {
                map.put(kind, 0);
            }
            
            for (int j = 0; j < coins.length() - 2; j++) {
                String coin = coins.substring(j, j + 3);
                map.put(coin, map.get(coin) + 1);
            }

            for (String kind : kinds) {
                sb.append(map.get(kind)).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
