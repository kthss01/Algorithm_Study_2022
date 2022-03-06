package Baekjoon.Bronze.Prob3_23348;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스트릿 코딩 파이터 - 브론즈 3
 * 
 * 동아리 총 점수 구성원들의 개인 점수 합
 * 개인 점수 세 가지 기술 점수의 합
 * 기술 점수는 해당 기술의 난이도와 사용한 횟수를 곱한 값
 * 
 * ex)
 *  기술 난이도 3, 6, 9
 *  P 1, 2, 3번 보여줌
 *  -> 3 * 1 + 6 * 2 + 9 * 3 = 42
 * 
 * 기술의 난이도와 동아리 별 각 팀원들이 사용한 기술의 횟수가 주어짐
 * 가장 높은 점수를 받은 동아리의 점수는 몇 점인지 구하기
 * 
 * 입력
 *  기술 난이도 A, B, C (0 <= A, B, C <= 1000)
 *  참가한 동아리의 수 N (1 <= N <= 1000)
 *  3N 개의 줄에 걸쳐 세 줄마다 각 동아리의 기술 사용 정보 주어짐
 *      a, b, c (0 <= a, b, c <= 100)
 * 
 * 출력
 *  가장 높은 점수를 받은 동아리의 점수 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int[] level = new int[3];
        level[0] = Integer.parseInt(token.nextToken());
        level[1] = Integer.parseInt(token.nextToken());
        level[2] = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(br.readLine());

        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            int sumScore = 0;
            for (int j = 0; j < 3; j++) {
                String[] score = br.readLine().split(" ");
                for (int k = 0; k < score.length; k++) {
                    sumScore += Integer.parseInt(score[k]) * level[k];
                }
                maxScore = Math.max(maxScore, sumScore);
            }
        }

        System.out.println(maxScore);
    }
}
