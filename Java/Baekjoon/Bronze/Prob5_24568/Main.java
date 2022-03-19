package Baekjoon.Bronze.Prob5_24568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Cupcake Party - 브론즈 5 (영어 문제)
 * 
 * 컵케잌 상자 1 - 8개 
 * 상자 2 - 3개 들어감
 * 
 * 학생 28명 있음
 * 
 * 각 상자 입력 들어올 때 학생 1개씩 주고 남은 컵케익 구하기
 * 
 * 입력
 *  R >= 0 (regular boxes)
 *  S >= 0 (small boxes)
 * 
 * 출력
 *  남은 컵케익 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());

        int left = r * 8 + s * 3 - 28;

        System.out.println(left);
    }
}
