package Baekjoon.Bronze.Prob1_10408;

import java.util.Scanner;

/**
 * The return of the King - 브론즈 1 (영어문제)
 * 
 * prolific 다작하는
 * 
 * 숫자가 앞에 0없이 쭉 이어져있음 1 ~ 10
 * 이거 다 더해서 평균 구하기
 * 
 * ex)
 *  310110
 *  3 10 1 10
 *  -> 6.0
 * 소수점 2째 자리까지
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String digit = sc.nextLine();

        double sum = 0;
        int cnt = 0;

        for (int i = 0; i < digit.length(); i++) {
            char num = digit.charAt(i);

            cnt++;

            if (num != '1') {
                sum += num - '0';
            } else if (i != digit.length() - 1 && digit.charAt(i + 1) == '0') {
                i++;
                sum += 10;
            } else {
                sum += num - '0';
            }
        }

        System.out.printf("%.2f\n", sum / cnt);

        sc.close();
    }
}
