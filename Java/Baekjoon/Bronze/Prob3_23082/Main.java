package Baekjoon.Bronze.Prob3_23082;

import java.util.Scanner;

/**
 * 골뱅이 찍기 - 뒤집힌 ㄱ - 브론즈 3
 * 
 * @ 찍기 뒤집힌 ㄱ 자 모양으로
 * 
 * 1
 * @@@@@
 * @
 * @
 * @
 * @
 * 
 * 3
 *  @@@@@@@@@@@@@@@
 *  @@@@@@@@@@@@@@@
 *  @@@@@@@@@@@@@@@
 *  @@@
 *  @@@
 *  @@@
 *  @@@
 *  @@@
 *  @@@
 *  @@@
 *  @@@
 *  @@@
 *  @@@
 *  @@@
 *  @@@
 * 
 * 입력
 *  N (1 <= N <= 100)
 * 
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

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

        // tail
        for (int i = 0; i < 4; i++) {            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append("@");
                }
                sb.append("\n");
            }
        }


        System.out.print(sb);

        sc.close();
    }
}
