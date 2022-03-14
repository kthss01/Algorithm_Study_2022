package Baekjoon.Bronze.Prob3_23803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 골뱅이 찍기 - ㄴ - 브론즈 3
 * 
 * 골뱅이 ㄴ 모양으로 찍기
 * 
 * ex)
 * 1
 * @
 * @
 * @
 * @
 * @@@@@
 * 
 * 3
 * @@@
 * @@@
 * @@@
 * @@@
 * @@@
 * @@@
 * @@@
 * @@@
 * @@@
 * @@@
 * @@@
 * @@@
 * @@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@
 * 
 * 입력
 *  N (1 <= N <= 100)
 * 
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // head
        for (int i = 0; i < 4; i++) {            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append("@");
                }
                sb.append("\n");
            }
        }

        // tail
        // row 갯수                
        for (int i = 0; i < n; i++) {
            // step 5번
            for (int j = 0; j < 5; j++) {
                // 각 step 갯수 n개
                for (int k = 0; k < n; k++) {
                    sb.append('@');
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
