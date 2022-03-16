package Baekjoon.Bronze.Prob3_23812;

import java.util.Scanner;

/**
 * 골뱅이 찍기 - 돌아간 ㅍ - 브론즈 3
 * 
 * 골뱅이 모양 찍기
 * 
 * 입력
 *  1
 * @   @
 * @@@@@
 * @   @
 * @@@@@
 * @   @
 * 
 *  3
 * @@@         @@@
 * @@@         @@@
 * @@@         @@@
 * @@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@
 * @@@         @@@
 * @@@         @@@
 * @@@         @@@
 * @@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@
 * @@@         @@@
 * @@@         @@@
 * @@@         @@@
 */
public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        makeDotComponent();
        makeStraightComponent();
        makeDotComponent();
        makeStraightComponent();
        makeDotComponent();

        System.out.print(sb);

        sc.close();
    }

    public static void makeDotComponent() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append("@");
            }
            for (int j = 0; j < n; j++) {
                sb.append("   ");
            }
            for (int j = 0; j < n; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }

    public static void makeStraightComponent() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 5; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }
}
