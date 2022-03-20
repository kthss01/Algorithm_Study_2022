package Baekjoon.Bronze.Prob3_1837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 암호제작 - 브론즈 3
 * 
 * 비밀키 만들기
 *  개인마다 어떤 특정한 소수 p, q 주어 두 소수의 곱 pq를 비밀키로 둠
 * 
 * 두 소수 p, q 중 하나라도 k보다 작은 암호는 좋지 않은 암호로 간주
 * 
 * 두 소수의 곱으로 이루어진 암호와 K가 주어졌을 때
 * 그 암호가 좋은 암호인지 좋지 않은 암호인지 작성
 * 
 * 입력
 *  P(4 <= P <= 10^100) K(2 <= K <= 10^6)
 * 
 * 출력
 *  좋은 암호면 GOOD
 *  아니면 BAD와 소수 r을 공백 구분 출력
 *      r은 암호를 이루는 두 소수 중 작은 소수 의미
 */
public class Main {

    static final int MAX_NUM = 1000000;
    static boolean[] arr = new boolean[MAX_NUM + 1];
    static int[] prime = new int[MAX_NUM + 1];
    static char[] P;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        // BigInteger p = new BigInteger(token.nextToken());
        // BigInteger k = new BigInteger(token.nextToken());
        
        // BigInteger prime = new BigInteger("2");

        // boolean isFind = false;
        // while (k.subtract(prime).longValue() > 0) {
        //     if (p.remainder(prime).longValue() == 0) {
        //         System.out.println("BAD " + prime);
        //         isFind = true;
        //         break;
        //     }

        //     prime = prime.add(new BigInteger("1"));
        // }

        // if (!isFind) {
        //     System.out.println("GOOD");
        // }

        // 에라토스테네스 체 이용
        int pSize = 0;
        for (int i = 2; i <= MAX_NUM; i++) {
            if (!arr[i]) {
                prime[pSize++] = i;
                for(int j = 2; j <= MAX_NUM/i; j++) {
                    arr[i*j] = true;
                }
            }
        }

        P = token.nextToken().toCharArray();
        K = Integer.parseInt(token.nextToken());

        int num = 0;
        boolean check = false;

        for (int i = 0; i < pSize; i++) {
            num = 0;
            if (prime[i] >= K) break;
            for (int j = 0; j < P.length; j++) {
                int t = (int)(P[j] - '0');
                num = (num * 10 + t) % prime[i];
            }
            if (num == 0) {
                System.out.println("BAD " + prime[i]);
                check = true;
                break;
            }
        }
        if(!check) {
            System.out.println("GOOD");
        }
    }
}
