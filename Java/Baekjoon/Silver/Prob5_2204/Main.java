package Baekjoon.Silver.Prob5_2204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 도비의 난독증 테스트 - 실버 5
 * 
 * 대소문자 구분되는 단어가 주어질 때 
 * 사전순으로 가장 앞서는지 맞추기
 * 
 * 입력
 *  각 테스트케이스 n (2 ~ 1000) 단어의 개수
 *  각 n줄 길이 최대 20인 단어 주어지며
 *  대소문자의 구분을 없앴을 때 똑같은 단어는 주어지지 않음
 *  마지막 입력 0 주어짐
 * 
 * 출력
 *  각 줄에 각 테스트케이스에서 사전상 가장 앞서는 단어 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            String[] word = new String[n];
            for (int i = 0; i < n; i++) {
                word[i] = br.readLine();
            }

            Arrays.sort(word, (o1, o2) -> {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            });

            sb.append(word[0]).append("\n");
        }

        System.out.print(sb);
    }    
}
