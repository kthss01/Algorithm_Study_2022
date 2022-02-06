package Baekjoon.Silver.Prob4_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 나는야 포켓몬 마스터 이다솜 - 실버 4
 * 
 * 포켓몬 이름을 보면 번호를 말하거나
 * 번호를 보면 이름을 말하기
 * 
 * 입력
 *  첫째 줄 포켓몬의 개수 N 문제의 개수 M
 *      1 ~ N,M ~ 100,000
 *  N개 줄 포켓몬 이름 
 *      모두 영어로만, 첫 글자만 대문자 나머지 소문자
 *          일부 포켓몬은 마지막 문자만 대문자일 수도 있음
 *          이름 길리 2 ~ 20
 *  M개 줄 문제가 입력으로 들어옴
 *  문제가 알파벳으로만 들어오면 포켓몬 번호 말하기
 *  숫자로만 들어오면 포켓몬 번호에 해당하는 문자 출력
 *      숫자 1 ~ N
 *      문자 반드시 도감에 있는 포켓몬 이름만 주어짐
 * 
 * 출력
 *  M개의 줄 각각의 문제에 대한 답 말하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        Map<String, Integer> pokedexToName = new HashMap<>();
        Map<Integer, String> pokedexToIndex = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            pokedexToName.put(name, i);
            pokedexToIndex.put(i, name);
        }

        for (int i = 0; i < m; i++) {
            String prob = br.readLine();
            if (pokedexToName.containsKey(prob)) {
                sb.append(pokedexToName.get(prob));
            } else {
                sb.append(pokedexToIndex.get(Integer.parseInt(prob)));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
