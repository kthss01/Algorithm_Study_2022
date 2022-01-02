package Prob2_18406;

import java.util.Scanner;

/**
 * 럭키 스트레이트 - 브론즈 2
 * 
 * 럭키 스트레이트 조건
 *  점수 N을 자릿수 기준으로 반으로 나누어
 *  왼쪽 부분의 각 자릿수의 합과 오른쪽 부분의 각 자릿수의 합
 *  이 같은 상황
 * ex)
 *  123,402
 *  123 = 6 402 = 6
 * 점수 N이 주어졌을 때, 럭키 스트레이트를 사용할 수 있는
 * 상태인지 아닌지 알려주기
 * 
 * 사용할 수 있다면 LUCKY 아니면 READY 출력
 * 점수 N의 자릿수는 항상 짝수 형태로만 주어짐
 * 
 * 입력
 *  N 10 ~ 99,999,999
 * 출력
 *  럭키 스트레이트면 LUCKY 아니면 READY 출력
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String num = sc.nextLine();
        int left = 0;
        int right = 0;

        for (int i = 0; i < num.length() / 2; i++) {
            left += num.charAt(i) - '0';
            right += num.charAt(num.length() - 1 - i) - '0';
        }

        System.out.println(left == right ? "LUCKY" : "READY");

        sc.close();
    }    
}
