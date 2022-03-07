package Baekjoon.Bronze.Prob3_23972;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 악마의 제안 - 브론즈 3
 * 
 * 악마는 자신에게 k원을 지불하면, 
 *  지불하고 남은 금액을 N배 만들어줌
 * 최소 몇 원을 가지고 있어야 악마에게 k원을 지불했을 때
 *  손해를 보지 않는지 알고 싶다
 * 
 * k, n이 주어졌을 때 손해 보지 않기 위해
 *  가지고 있어야 하는 최소 금액 x 구하기
 *  단, 금액은 정수여야 함
 * 
 * 입력
 *  k, n (1 <= k, n <= 200,000,000)
 * 
 * 출력
 *  최소 금액 x 출력
 *  손해를 보게 된다면 -1 출력
 * 
 * 
 * x <= (x - k) * n
 * (1 - n) x = - n k
 * x = -nk / (1 - n)
 * 
 * -> 문제 잘못이해했었음 N배로 만들어주는거였음
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long k = sc.nextLong();
        long n = sc.nextLong();

        // BigInteger biK = new BigInteger(String.valueOf(k));
        // BigInteger biN = new BigInteger(String.valueOf(n));

        long x = -1;
        if (n > 1) {
            long up = n * k % (n - 1) == 0 ? 0 : 1;
            x = (n * k) / (n - 1) + up;
            // x = biN.multiply(biK)
            //     .divide(biN.subtract(new BigInteger("1")))
            //     .longValue();
        }

        // if (n > 1) {
        //     x = k + 1;
        //     while (true) {
        //         if (x <= (x - k) * n) {
        //             break;
        //         }
        //         x++;
        //     }
        // }

        System.out.println(x);

        sc.close();
    }    
}
