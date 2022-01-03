package Baekjoon.Gold.Prob3_1644;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 소수의 연속합 - 골드 3
 * 
 * 하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다.
 * 몇가지 자연수의 예를 들어보면 다음과 같다.
 * 
 *  3 : 3 (한 가지)
 *  41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
 *  53 : 5+7+11+13+17 = 53 (두 가지)
 * 
 * 하지만 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데
 * 20이 그 예
 *  7 + 13을 하면 20이 되기는 하나
 *  7 + 13은 연속이 아니기에 적합한 표현이 아니다.
 *  또한 한 소수는 반드시 한 번만 덧셈에 사용될 수 있기 때문에
 *  3 + 5 + 5 + 7과 같은 표현도 적합하지 않다.
 * 
 * 자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로
 *  나타낼 수 있는 경우의 수를 구하기
 * 
 * 입력
 *  자연수 N (1 ~ N ~ 4,000,000)
 * 
 * 출력
 *  자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수 출력
 * 
 * 해결 방법 생각
 *  에라토스테네스 체로 모든 소수를 확인하고
 *  연속된 수로 해당 값이 만들어지는지 확인하기
 *  -> 시간 초과 나버림
 *      풀이 - 누적합을 이용해서 체크하면 O(n^2)라 시간초과 난다고함
 *      투포인터 써서 풀라고함
 */
public class Main {
    
    static int MAX = 4000000;
    static boolean[] array = new boolean[MAX + 1];
    static int[] prime = new int[283146 + 1];
    static int cnt;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int ans = 0;
        int sum = 0;

        calPrime();
        setPrime();

        int s = 0, e = 0;
        while (e <= cnt) {
            if (sum < n) {
                sum += prime[e++];
                continue;
            }

            if (sum == n) {
                ans++;
            }

            sum -= prime[s++];
        }

        System.out.println(ans);

        sc.close();
    }

    private static void calPrime() {
        int sqrt = (int) Math.sqrt(MAX);
        for (int i = 2; i <= sqrt; i++) {
            if (array[i]) {
                continue;
            }

            for (int j = i + i; j <= MAX; j += i) {
                array[j] = true;
            }
        }
    }

    private static void setPrime() {
        for (int i = 2; i <= MAX; i++) {
            if (!array[i]) {
                prime[cnt++] = i;
            }
        }
    }
}
