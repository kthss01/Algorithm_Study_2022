package Baekjoon.Bronze.Prob2_2858;

import java.util.Scanner;

/**
 * 기숙사 바닥 - 브론즈 2
 * 
 * 방의 크기 LxW
 * 가장자리 빨간색으로 나머지 갈색으로 채우려고 함
 * 
 * 빨간색과 갈색 타일의 개수가 주어질 때
 * 방의 크기 구하기
 * 
 * 입력
 *  빨간색 타일의 수 R 갈색 타일의 수 B
 *  (8 <= R <= 5000, 1 <= B <= 2,000,000)
 * 
 * 출력
 *  L W 공백 구분하여 출력
 *  만약, 두 수가 다르면 큰 수가 L 작은 수 W
 *  항상 정답이 유일한 경우만 입력으로 주어짐
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int b = sc.nextInt();

        int sum = r + b;

        int l, w;  
        int xy = (r + 4) / 2;
        for (int i = 1; i < xy; i++) {
            w = i;
            l = xy - w;
            
            if (l * w == sum) {
                System.out.println(l + " " + w);
                break;
            }
        }

        sc.close();
    }
}
