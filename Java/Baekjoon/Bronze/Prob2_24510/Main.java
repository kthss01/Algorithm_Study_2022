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

        for (int i = 0; i < c; i++) {
            String str = br.readLine();
            int temp = 0;
            while (str.indexOf("for") != -1 || str.indexOf("while") != -1) {
                temp++;

                int nextStart = 0;

                int idxFor = str.indexOf("for");
                int idxWhile = str.indexOf("while");
                if (idxFor != -1 && idxWhile != -1) {
                    nextStart = idxFor < idxWhile ? idxFor + 3 : idxWhile + 5;
                } else if (idxFor == -1) {
                    nextStart = idxWhile + 5;
                } else {
                    nextStart = idxFor + 3;
                }

                if (str.length() > nextStart) {
                    str = str.substring(nextStart);
                } else {
                    break;
                }
            }
            cnt = Math.max(temp, cnt);
        }

        System.out.println(cnt);
    }
}
