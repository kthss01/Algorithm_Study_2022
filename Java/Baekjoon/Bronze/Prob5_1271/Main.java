package Baekjoon.Bronze.Prob5_1271;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 엄청난 부자2 - 브론즈 5
 * 
 * 돈 똑같이 분배
 * 얼마씩주고 남은 돈 구하기
 * 
 * 입력
 *  가진돈 n, 생명체 수 m (1 <= m <= n <= 10^1000)
 * 
 * 출력
 *  하나에게 돌아가는 양 출력
 *  1원씩 분배할 수 없는 남은 돈 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        BigInteger bi = new BigInteger(token.nextToken());
        BigInteger bi2 = new BigInteger(token.nextToken());

        System.out.println(bi.divide(bi2));
        System.out.println(bi.remainder(bi2));
    }
}
