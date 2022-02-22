package Baekjoon.Bronze.Prob1_5426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 비밀 편지 - 브론즈 1
 * 
 * 편지 암호화
 * 내용 정사각형에 작성
 * 그 다음 시계방향으로 90도 회전
 * 그 다음, 첫 행부터 마지막 행까지 순서대로 다시 편지 작성
 * 편지에 띄어쓰기 안함
 * 
 * ex)
 * RosesAreRedVioletsAreBlue
 * -> eedARBtVrolsiesuAoReerles
 * 
 * 암호화한 편지가 주어졌을 때, 원래 내용 구하기
 * 
 * 입력
 *  테스트 케이스의 개수
 *      최대 100개
 *  각 테스트 케이스 한 줄 암호화된 편지 주어짐
 *      편지 알파벳 소문자와 대문자로만 이루어짐
 *      길이 1보다 크거나 같고 10,000보다 작거나 같으며
 *      항상 제곱수
 * 
 * 출력
 *  각 테스트 케이스마다 원래 메시지 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String letter = br.readLine();

            int k = (int) Math.sqrt(letter.length());
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < k; l++) {
                    int x = k - j - 1;
                    int y = l * k;
                    sb.append(letter.charAt(x + y));
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
