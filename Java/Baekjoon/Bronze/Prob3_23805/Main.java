package Baekjoon.Bronze.Prob3_23805;

import java.util.Scanner;

/**
 * 골뱅이 찍기 - 돌아간 ㄹ - 브론즈 3
 * 
 * 골뱅이 모양 찍기
 * 
 * 입력
 * 1
 * @@@ @
 * @ @ @
 * @ @ @
 * @ @ @
 * @ @@@
 * 
 * 3
 * @@@@@@@@@   @@@
 * @@@@@@@@@   @@@
 * @@@@@@@@@   @@@
 * @@@   @@@   @@@
 * @@@   @@@   @@@
 * @@@   @@@   @@@
 * @@@   @@@   @@@
 * @@@   @@@   @@@
 * @@@   @@@   @@@
 * @@@   @@@   @@@
 * @@@   @@@   @@@
 * @@@   @@@   @@@
 * @@@   @@@@@@@@@
 * @@@   @@@@@@@@@
 * @@@   @@@@@@@@@
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        // head
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    sb.append("@");
                }
            }
            for (int j = 0; j < n; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < n; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }

        // body
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append("@");
                }
                for (int k = 0; k < n; k++) {
                    sb.append(" ");
                }
                for (int k = 0; k < n; k++) {
                    sb.append("@");
                }
                for (int k = 0; k < n; k++) {
                    sb.append(" ");
                }
                for (int k = 0; k < n; k++) {
                    sb.append("@");
                }
                sb.append("\n");
            }
        }

        // tail
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append("@");
            }
            for (int j = 0; j < n; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    sb.append("@");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);

        sc.close();
    }
}
