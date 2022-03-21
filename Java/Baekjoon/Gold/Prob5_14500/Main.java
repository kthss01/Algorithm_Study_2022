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
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Shape {
    List<Point> position;

    Shape(List<Point> position) {
        this.position = position;
    }

    public int compute(int[][] board, int w, int h, int x, int y) {
        int sum = 0;

        for (Point point : position) {
            int px = point.x + x;
            int py = point.y + y;

            if (px < 0 || px >= w || py < 0 || py >= h) {
                return -1;
            }

            sum += board[px][py];
        }

        return sum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        // Shape 만들기
        List<Shape> shapes = makeShape();

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }


    }

    private static List<Shape> makeShape() {
        List<Shape> list = new ArrayList<>();

        int[][] points = {
            {0, 0}, {0, 1}, {0, 2}, {0, 3},
            {0, 0}, {0, 1}, {1, 0}, {1, 1},
            {0, 0}, {1, 0}, {2, 0}, {2, 1},
            {0, 0}, {1, 0}, {1, 1}, {2, 1},
            {0, 0}, {0, 1}, {0, 2}, {1, 1},
        };

        for (int i = 0; i < 5; i++) {
            List<Point> position = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                int x = points[i * 4 + j][0];
                int y = points[i * 4 + j][1];
                position.add(new Point(x, y));
            }
            list.add(new Shape(position));
        }

        return list;
    }
}
