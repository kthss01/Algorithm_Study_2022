package Baekjoon.Bronze.Prob2_24510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 시간복잡도를 배운 도도 - 브론즈 2
 * 
 * 같은 줄에 있는 반복문의 최대 개수 구하기
 * for while이 있으면 반복문으로 생각
 * 
 * 입력
 *  C (1 <= C <= 100) 코드의 줄 개수
 *  코드 입력
 *      입력으로 주어진 코드 모두 알파벳 소문자
 *      각 줄 10000자를 넘지 않음
 * 출력
 *  같은 줄에 있는 반복문의 최대 개수 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        int cnt = 0;

        // for (int i = 0; i < c; i++) {
        //     String str = br.readLine();
        //     str = str.replaceAll("for", "#");
        //     str = str.replaceAll("while", "#");
        //     str = str.replaceAll("[a-z]", "");
        //     cnt = Math.max(str.length(), cnt);
        // }

        while (c --> 0) {
            int temp = 0;
            String str = br.readLine();

            for (int i = 0; i < str.length() - 2; i++) {
                if (i < str.length() - 2 
                    && str.charAt(i) == 'f'
                    && str.charAt(i + 1) == 'o'
                    && str.charAt(i + 2) == 'r') {
                    temp++;
                    i += 2;
                }

                if (i < str.length() - 4 
                    && str.charAt(i) == 'w'
                    && str.charAt(i + 1) == 'h'
                    && str.charAt(i + 2) == 'i'
                    && str.charAt(i + 3) == 'l'
                    && str.charAt(i + 4) == 'e') {
                    temp++;
                    i += 4;
                }
            }

            cnt = Math.max(cnt, temp);
        }

        System.out.println(cnt);
    }
}
