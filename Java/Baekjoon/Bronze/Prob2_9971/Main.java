package Baekjoon.Bronze.Prob2_9971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Hardest Problem Ever - 브론즈 2 (영어문제)
 * 
 * intrigue 음모
 * ciphers 암호
 * incredibly 엄청나게
 * 
 * 암호는 A -> F 이런 식으로 되어있음
 * 
 * Cipher text
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * Plain text
 * V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
 * 
 * 모두 대문자 영문 제외 다 똑같이 남아있음
 * 
 * 입력
 *  최대 100 데이터 셋
 *      각각 아래 설명에 맞게 구성됨
 *      모두 대문자
 *      START
 *      암호 메시지
 *      END
 *  입력 마지막 ENDOFINPUT
 * 
 * 출력
 *  암호 풀어서 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String ciphers = "VWXYZABCDEFGHIJKLMNOPQRSTU";

        while (true) {
            String str = br.readLine();
            if (str.equals("START")) {
                continue;
            } else if (str.equals("END")) {
                sb.append("\n");
                continue;
            } else if (str.equals("ENDOFINPUT")) {
                break;
            }

            for (char ch : str.toCharArray()) {
                if (ch >= 'A' && ch <= 'Z') {
                    char temp = ciphers.charAt(ch - 'A');
                    sb.append(temp);
                } else {
                    sb.append(ch);
                }
            }
        }

        System.out.print(sb);
    }
}
