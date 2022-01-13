package Baekjoon.Bronze.Prob4_20673;

import java.util.Scanner;

/**
 * Covid-19 - 브론즈 4 (영어 문제)
 * 
 * 차트에 도시별로 covid-19 위험을 색깔로 표시하려고함
 * red, yellow, white
 * 
 * 새로운 환자 수, 새로운 입원을 알 수 있을 때
 * 색깔 구하기
 * 
 * 신규환자 수 최대 50명, 신규입원 최대 10명 white
 * 신규 입원 30 이상 red
 * 그 밖에 yellow
 * 
 * 입력
 *  p 0 ~ 1000 신규 환자
 *  q 0 ~ 500 신규 입원
 *      q <= p
 * 
 * 출력
 *  White, Yellow, Red 중 하나로 출력
 * 
 * 재채점으로 인해 틀려서 다시 품
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int q = sc.nextInt();

        if (p <= 50 && q <= 10) {
            System.out.println("White");
        } else if (q > 30) {
            System.out.println("Red");
        } else {
            System.out.println("Yellow");
        }

        sc.close();
    }
}
