package Baekjoon.Silver.Prob4_1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 베스트셀러 - 실버 4
 * 
 * 오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때,
 * 가장 많이 팔린 책의 제목 출력하기
 * 
 * 입력
 *  책의 개수 N 1000보다 작거나 같은 자연수
 *  N개의 줄에 책의 제목이 입력으로 들어온다
 *  책의 제목의 길이는 50보다 작거나 같고,
 *  알파벳 소문자로만 이루어짐
 * 출력
 *  첫째 줄에 가장 많이 팔린 책의 제목 출력
 *  만약 가장 많이 팔린 책의 책이 여러개일 경우
 *  사전 순으로 가장 앞서는 제목 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (map.containsKey(book)) {
                map.put(book, map.get(book) + 1);
            } else {
                map.put(book, 1);
            }
        }

        int max = map.values().stream()
                    .mapToInt(x -> x).max().getAsInt();
        
        List<String> answer = new ArrayList<>();
        map.forEach((key, value) -> {
            if (value == max) {
                answer.add(key);
            }
        });

        answer.sort(Comparator.naturalOrder());

        System.out.println(answer.get(0));
    }
}
