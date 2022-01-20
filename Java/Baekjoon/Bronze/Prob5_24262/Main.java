package Baekjoon.Bronze.Prob5_24262;

import java.util.Scanner;

/**
 * 알고리즘 수업 - 알고리즘 수행 시간 1 - 브론즈 5
 * 
 * 입력의 크기 n이 주어지면
 * MenOfPassion 알고리즘 수행 시간을 예제 출력과
 * 같은 방식으로 출력하기
 * 
 * MenOfPassion 알고리즘은 다음과 같다
 * MenOfPassion(A[], n) {
 *  i = [n / 2];
 *  return A[i]; // 코드1
 * }
 * 
 * 입력
 *  입력의 크기 n 1 ~ 500,000
 * 출력
 *  코드1의 수행 횟수 출력
 *  알고리즘의 수행 시간이 상수 시간이 소요되면 0
 *  n에 비례하면 1,
 *  n^2에 비례하면 2,
 *  n^3에 비례하면 3,
 *  n^3보다 큰 시간에 비례하면 4 출력
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(1);
        System.out.println(0);
        sc.close();
    }
}
