package Baekjoon.Gold.Prob5_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 테트로미노 - 골드 5 
 * 
 * 정사각형은 서로 겹치면 안된다
 * 도형은 모두 연결되어 있어야 한다.
 * 정사각형의 변끼리 연결되어 있어야 한다. 꼭지점과 꼭지점만 맞닿아 있으면 안된다.
 * 
 * 테트리스라고 생각
 * 
 * OOOO 
 * 
 * OO
 * OO
 * 
 * O
 * O
 * OO
 * 
 * O
 * OO
 *  O
 * 
 * OOO
 *  O
 * 
 * 위 모양 있음
 * 
 * 테트로미노 하나 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합
 * 최대로 하기
 * 
 * 회전이나 대칭 가능
 * 
 * 입력
 *  종이의 세로 크기 N, 가로 크기 M (4 <= N, M <= 500)
 *  주어지는 수 1000 넘지 않는 자연수
 * 
 * 출력
 *  최댓값 출력
 */

class Point {
    int x;
    int y;
}

class Shape {
    List<Point> positions = new ArrayList<>();

    public int compute(int[][] board, int x, int y) {
        int sum = 0;

        return sum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }


    }
}
