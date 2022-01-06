package Baekjoon.Gold.Prob5_2174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 로봇 시뮬레이션 - 골드 5
 * 
 * 가로 A (1 <= A <= 100)
 * 세로 B (1 <= B <= 100) 크기의 땅
 * 이 땅위에 로봇들이 N (1 <= N <= 100)
 * 
 * 로봇들의 초기 위치는 x좌표, y좌표로 나타난다.
 * x 좌표는 왼쪽부터 y좌표는 아래부터 순서가 매겨진다
 * 또한 각 로봇은 맨 처음에 NWES 중 하나의 방향을 향해 서 있다.
 * 초기에 서 있는 로봇들의 위치는 서로 다르다
 * 
 * 이러한 로봇들에 M(1 <= M <= 100)개의 명령을 내리려고 한다.
 * 각각의 명령은 순차적으로 실행된다.
 * 즉, 하나의 명령을 한 로봇에서 내렷으면,
 * 그 명령이 완수될 때까지 그 로봇돠 다른 모든 로봇에게
 * 다른 명령을 내릴 수 없다.
 * 각각의 로봇에 대해 수행하는 명령은 다음 3가지
 *  1. L: 로봇이 향하고 있는 방향을 기존으로 왼쪽으로 90도 회전
 *  2. R: 로봇이 향하고 있는 방향을 기준으로 오른쪽으로 90도 회전
 *  3. F: 로봇이 향하고 있는 방향을 기준으로 앞으로 한 칸 움직임
 * 
 * 간혹 로봇들에게 내리는 명령이 잘못될 수도 있기 때문에,
 * 로봇들에게 명령을 내리기 전에 한 번 시뮬레이션을
 * 해보면서 안정성을 검증라혀 한다.
 * 
 * 잘못된 명령에는 다음의 두 가지가 있을 수 있다.
 *  1. Robot X crashes into the wall: X번 로봇이 벽에 충돌하는 경우
 *  즉, 주어진 땅의 밖으로 벗어나는 경우
 *  2. Robot X crashes into robot Y: X번 로봇이 움직이다가
 *  Y번 로봇에 충돌하는 경우
 * 
 * 입력
 *  첫째 줄에 두 정수 A, B가 주어짐
 *  다음 줄 두 정수 N, M
 *  다음 N개의 줄 각 로봇의 초기 위치(x, y 좌표순) 및 방향
 *  다음 M개의 줄 각 명령이 명령을 내리는 순서대로 주어짐
 *  각각의 명령은 명령을 내리는 로봇, 
 *  명령의 종류(위에 나와 있는)
 *  명령의 반복 회수로 나타냄
 *  각 명령의 반복 회수는 1 이상 100 이하
 * 
 * 출력
 *  첫째 줄에 시물레이션 결과 출력
 *  문제 없는 경우 OK 
 *  그 외의 경우에는 위의 형식대로 출력
 *  만약 충돌이 여러 번 발생하는 경우
 *  가장 먼저 발생하는 충돌 출력
 */

class Robot {
    int x;
    int y;
    String dir;

    public Robot(int x, int y, String dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public boolean checkRobotCollision(Robot robot) {
        return robot.x == x && robot.y == y;
    }

    public boolean checkWallCollision(int a, int b) {
        return x <= 0 || x > a | y <= 0 || y > b;
    }

    public void rotateLeft() {
        switch (dir) {
            case "N":
                dir = "W";
                break;
            case "W":
                dir = "S";
                break;
            case "S":
                dir = "E";
                break;
            case "E":
                dir = "N";
                break;    
        }
    }

    public void rotateRight() {
        switch (dir) {
            case "N":
                dir = "E";
                break;
            case "W":
                dir = "N";
                break;
            case "S":
                dir = "W";
                break;
            case "E":
                dir = "S";
                break;    
        }
    }

    public void forward() {
        switch (dir) {
            case "N":
                y++;
                break;
            case "W":
                x--;
                break;
            case "S":
                y--;
                break;
            case "E":
                x++;
                break;    
        }
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        ArrayList<Robot> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            String dir = token.nextToken();
            list.add(new Robot(x, y, dir));
        }

        boolean isCollision = false;
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(token.nextToken());
            String order = token.nextToken();
            int cnt = Integer.parseInt(token.nextToken());

            Robot robot = list.get(index - 1);

            for (int j = 0; j < cnt; j++) {                
                switch (order) {
                    case "L":
                        robot.rotateLeft();
                        break;
                    case "R":
                        robot.rotateRight();
                        break;  
                    case "F":
                        robot.forward();
                        if (robot.checkWallCollision(a, b)) {
                            sb.append(String.format("Robot %d crashes into the wall\n", index));
                            isCollision = true;
                        } else {
                            for (int k = 0; k < list.size(); k++) {
                                if (index - 1 != k) {
                                    Robot robot2 = list.get(k);
                                    if (robot.checkRobotCollision(robot2)) {
                                        sb.append(String.format("Robot %d crashes into robot %d\n", index, k + 1));
                                        isCollision = true;
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
                if (isCollision) {
                    break;
                }
            }
            if (isCollision) {
                break;
            }
        }

        if (!isCollision) {
            sb.append("OK").append("\n");
        }

        System.out.println(sb);
    }
}
