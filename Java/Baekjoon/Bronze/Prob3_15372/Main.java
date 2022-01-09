package Baekjoon.Bronze.Prob3_15372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * A Simple Problem - 브론즈 3 (영어 문제)
 * 
 * 양수 N 이 주어질 때 
 * N = b * k에서
 * 최소 양의 값 k를 구하기
 * 
 * N이 주어질 때
 * N의 제곱이 배수가 되는 최소의 k 값 구하기
 * 
 * 테스트 케이스 T (1 <= T <= 200000)
 * N (1 <= N <= 200000)
 * 
 * -> 전에 풀었는데 시간초과남
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            BigInteger bi = new BigInteger(br.readLine());
            sb.append(bi.multiply(bi)).append("\n");
        }

        System.out.println(sb);
    }
}
