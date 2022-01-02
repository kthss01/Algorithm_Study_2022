package Prob4_19698;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 헛간 청약 - 브론즈 4
 * 
 * 헛간 W x H 직사각형 
 * N 마리 소 응모
 * 소 한 마리당 L x L 크기의 공간 배정 계획
 * 
 * 헛간을 최대한 효율적으로 나누어 최대한 많은 소를
 * 입주 시키려고 함
 * 헛간에는 최대 몇 마리의 소들이 입주할 수 있는지 출력
 * 소들이 입주하는 공간의 각 변은 직사각형의 각 변에 대해
 * 수평 혹은 수직이어야 한다.
 * 
 * 입력
 *  소들의 수 N, 헛간의 크기를 나타내는 W H
 *  소들에게 배정되는 공간의 크기 L 순서대로 주어짐
 *  1 <= N,W,H,L <= 1000
 * 
 * 출력
 *  헛간에 최대 몇 마리의 소들이 입주할 수 있는지 출력
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());
        int h = Integer.parseInt(token.nextToken());
        int l = Integer.parseInt(token.nextToken());

        int ans = Math.min(n, (w / l) * (h / l));
        System.out.println(ans);
    }
}
