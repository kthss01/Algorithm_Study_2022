package Baekjoon.Gold.Prob4_9935;

import java.util.Scanner;

/**
 * 문자열 폭발 - 골드 4
 * 
 * 폭발 문자열이 있는데 폭발하면
 * 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다.
 * 
 * 문자열이 폭발 문자열을 포함하고 있는 경우
 *  모든 폭발 문자열이 폭발하게 된다.
 *  남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
 * 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
 * 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
 * 
 * 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 함
 * 남아있는 문자가 없는 경우가 있다.
 * 이때는 "FRULA"를 출력
 * 폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.
 * 
 * 입력
 *  첫째 줄 문자열
 *      문자열의 길이 1보다 크거나 같고, 1,000,000보다 작거나 같다.
 *  둘째 줄 폭발 문자열
 *      길이 1보다 크거나 같고, 36보다 작거나 같다.
 *  두 문자열은 모두 알파벳 소문자, 대문자, 숫자, 0, 1, ... , 9로만 이루어짐
 * 
 * 출력
 *  첫째 줄에 모든 폭발이 끝난 후 남은 문자열을 출력한다.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append(sc.nextLine());
        String boom = sc.nextLine();

        while (sb.indexOf(boom) != -1) {
            int index = sb.indexOf(boom);
            sb.delete(index, index + boom.length());
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }

        sc.close();
    }
}
