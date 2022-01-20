package Baekjoon.Silver.Prob5_13706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 제곱근 - 실버 5
 * 
 * 정수 N이 주어졌을 때, N의 제곱근 구하기
 * 
 * 입력
 *  양의 정수 N 
 *  N의 제곱근은 항상 정수, N의 길이 800자리를 넘지 않음
 * 
 * 출력
 *  정수 N의 제곱근 출력
 * java8에선 sqrt 없어서 java11로 품
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bi = new BigInteger(br.readLine());
        System.out.println(bi.sqrt().toString(10));
    }
}
