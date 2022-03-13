package Baekjoon.Bronze.Prob3_23794;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * 골뱅이 찍기 - 정사각형 - 브론즈 3
 * 
 * 예제와 같은 규칙으로 골뱅이 출력하기
 * 
 * 입력 
 *  n (1 <= n <= 100)
 * 
 * 1
 * @@@
 * @ @
 * @@@
 * 
 * 3
 * @@@@@
 * @   @
 * @   @
 * @   @
 * @@@@@
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        // head
        for (int i = 0; i < n + 2; i++) {
            sb.append("@");
        }
        sb.append("\n");

        // body
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (j == 0 || j == n + 1) {
                    sb.append("@");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");   
        }

        // tail
        for (int i = 0; i < n + 2; i++) {
            sb.append("@");
        }
        sb.append("\n");

        System.out.print(sb);

        sc.close();
    }
}
