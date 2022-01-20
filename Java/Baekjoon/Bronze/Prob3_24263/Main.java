package Baekjoon.Bronze.Prob3_24263;

import java.util.Scanner;

/**
 * 알고리즘 수업 - 알고리즘의 수행 시간2 - 브론즈 3
 * 
 * MenOfPassion 알고리즘
 * MenOfPassion(A[], n) {
 *  sum <- 0;
 *  for i <- 1 to n
 *      sum <- sum + A[i]; # 코드1
 *  return sum
 * }
 * 
 * 입력
 *  입력의 크기 n 1 ~ 500,000
 * 출력
 *  코드1 수행 횟수 출력
 *  상수 시간 소요되면 0
 *  n 비례 1
 *  n^2 비례 2 
 *  n^3 비례 3
 *  n^3보다 큰 시간에 비례하면 4 출력
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(n);
        System.out.println(1);

        sc.close();
    }    
}
