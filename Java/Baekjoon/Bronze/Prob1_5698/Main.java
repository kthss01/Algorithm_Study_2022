package Baekjoon.Bronze.Prob1_5698;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Tautogram - 브론즈 1
 * 
 * 시형
 * Tautogram 매우 특별한 형태의 두운법
 * 인접한 단어가 같은 글자로 시작하는 것
 * 문장이 Tautogram이 되려면, 모든 단어가 같은 글자로 시작해야함 
 * 
 * ex)
 *  Flowers Flourish from France
 *  Sam Simmonds speaks sofly
 *  Peter plckEd pePPers
 *  truly tautograms triumph
 * 
 * 편지에 있는 문장이 주어졌을 때 Tautogram인지 아닌지 알아내기
 * 
 * 입력
 *  각 테스트 케이스 한 줄
 *      편지의 한 문장에 해당
 *  문장 최대 50개 단어
 *      공백으로 구분
 *      단어는 알파벳 대문자와 소문자로 이루어짐 길이 최대 20
 *  단어 적어도 한 글자를 포함, 문장 적어도 한 단어 포함
 *  마지막 테스트 케이스의 다음 줄에 *이 하나 주어짐
 * 
 * 출력
 *  각 테스트 케이스에 대해서 
 *  입력으로 주어진 문장이 Tautogram이라면 'Y' 아니면 'N'
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        while (true) {
            String str = br.readLine();
            if (str.equals("*")) {
                break;
            }
            str = str.toLowerCase();
            token = new StringTokenizer(str);

            boolean isTautogram = true;
            char ch = token.nextToken().charAt(0);
            while (token.hasMoreTokens()) {
                char temp = token.nextToken().charAt(0);
                if (temp != ch) {
                    isTautogram = false;
                    break;
                }
            }
            sb.append(isTautogram ? "Y" : "N").append("\n");
        }

        System.out.print(sb);
    }
}
