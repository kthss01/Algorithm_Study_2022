package Baekjoon.Bronze.Prob1_9557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Arabic and English - 브론즈 1
 * 
 * Arabic 오른쪽에서 왼쪽으로 쓰고
 * English 왼쪽에서 오른쪽으로 쓴다고 함
 * 같이 쓸 때 문제가 발생함
 * 
 * corrupted 손상된
 * 
 * 영어 단어 하나를 중심으로 순서를 유지한채 뒤집는거 같음
 * 
 * # #### ### abc ##
 * ## abc # #### ### 이렇게 abc를 기준으로 순서 유지한채 뒤집는거 같음
 * 
 * 입력
 *  T (1 <= T <= 100) test cases
 *  2T lines 
 *      N (1 <= N <= 100) 
 *      N words separated by single spaces with no leading or trailing spaces
 *          each word will be at least 1 character 
 *          and at most 10 characters long
 *      Each word will be either Arabic or English
 *      Arabic words will consist of one to ten # letter
 *      English words will consist of one to ten English lower case letters
 *      Each line contains at most one English word
 * 
 * 출력
 *  fixed line of input text
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer token = new StringTokenizer(br.readLine());
            String[] words = new String[n];
            int index = n;
            for (int j = 0; j < words.length; j++) {
                words[j] = token.nextToken();
                if (!words[j].contains("#")) {
                    index = j;
                }
            }
            
            for (int j = index + 1; j < n; j++) {
                sb.append(words[j]).append(" ");                
            }

            if (index != n) {
                sb.append(words[index]);
                if (index != 0) {
                    sb.append(" ");
                }
            }

            for (int j = 0; j < index; j++) {
                sb.append(words[j]);
                if (j != index - 1) {
                    sb.append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
