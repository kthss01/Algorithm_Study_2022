package Baekjoon.Silver.Prob3_9951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Word Extraction - 실버3 (영어 문제)
 * 
 * punctuation - 구두
 * 
 * 문장 입력 받았을 때 단어별로 묶어서 
 * 중복 제거하고 숫자로만 된거 제거하고
 * 정렬해서 출력하기
 * 
 * 입력
 *  한줄 문장 입력
 *  마지막 줄 #로 입력 
 * 
 * 출력
 *  라인별 출력 한줄 공백 구분
 *  단어 줄마다 소문자로 출력
 *  "",''-.!? 이런거 모두 제외
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        
        while (true) {
            String str = br.readLine();

            if (str.equals("#")) {
                break;
            }

            if (sb.length() != 0) {
                sb.append("\n");
            }

            token = new StringTokenizer(str);

            Set<String> words = new LinkedHashSet<>();
            while (token.hasMoreTokens()) {
                words.add(token.nextToken().toLowerCase()
                                            .replaceAll("[\\W_]", ""));
            }

            ArrayList<String> list = new ArrayList<>(words);
            Collections.sort(list);

            for (String word : list) {
                if (word.equals("") || word.matches("^[0-9]*$")) {
                    continue;
                }
                sb.append(word).append("\n");
            }
        }

        System.out.print(sb);
    }
}
