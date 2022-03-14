package Baekjoon.Bronze.Prob3_23804;

import java.util.Scanner;

/**
 * 골뱅이 찍기 - ㄷ - 브론즈 3
 * 
 * ㄷ자 모양 만들기
 * 
 * 입력
 *  N (1 <= N <= 100)
 * 
 * 1
 * @@@@@
 * @
 * @
 * @
 * @@@@@
 * 
 * 3
 * @@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@
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
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        // head
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
        
        // body
        for (int i = 0; i < 3; i++) {            
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

        sc.close();
    }
}
