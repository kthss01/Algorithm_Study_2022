package Baekjoon.Bronze.Prob1_1855;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 암호 - 브론즈 1
 * 
 * 암호화
 *  암호화 할 문자열을 1,1부터 위에서 아래 순서대로 채운다.
 *  그리고 가장 밑의 행을 채운 후에 오른쪽 열에서 다시 같은 과정 반복
 *  
 *  ex)
 *      abcdefghijkl 3개의 열로 암호화 한다고 하자
 * 
 *      a e i
 *      b f j
 *      c g k
 *      d h l
 * 
 *  그런 후에 왼쪽 -> 오른쪽, 오른쪽 -> 왼쪽 반복하면서 다시 문자열 만듬
 *  => aeijfbcgklhd
 * 
 * 암호화 된 문자열과 몇 개의 열로 암호화를 하였는지 주어졌을 때
 * 원래의 문자열 구하기
 * 
 * 입력
 *  열의 개수 K (1 ~ 20)
 *  암호화된 문자열 (모두 영소문자)
 *      문자열의 길이 200 이하 K의 배수
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String password = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        int r = password.length() / k;

        for (int i = 0; i < r; i++) {
            String sub = password.substring(i * k, (i + 1) * k);
            if (i % 2 == 0) {
                temp.append(sub);
            } else {
                temp.append(new StringBuilder(sub).reverse());
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < r; j++) {
                sb.append(temp.charAt(i + j * k));
            }
        }

        System.out.println(sb);
    }
}
