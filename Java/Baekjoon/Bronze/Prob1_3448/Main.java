package Baekjoon.Bronze.Prob1_3448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자 인식 - 브론즈 1
 * 
 * 문자가 주어질 때 인식률 계산하기
 * 인식률 : 인식한 문자의 수 R, 전체의 문자 수 A R/A
 * 줄바꿈 문자는 문자로 세지 않음
 * 
 * 입력
 *  N개의 테스트 케이스
 *  첫째 줄 테스트 케이스 개수 N
 *  각 테스트 케이스 적어도 한 줄
 *  인식하지 못한 문자는 '#'으로 표시
 *  각 테스트 케이스의 다음에는 빈 줄이 한 칸이 있음
 *  각 줄 100글자 넘지 않고, 줄 의수도 200줄을 넘지 않음
 * 
 * 출력
 *  각 테스트 케이스에 대해서 인식률을 계산한 뒤 양식에 맞게 출력
 *  "Efficiency ratio is X%." 와 같은 형태
 *  X는 인식률을 퍼센트로 표시한 것이고
 *  소수점 두 자리 이상인 경우에는 둘째 자리에서 반올림
 *  단, 반올림 결과가 정수이면 정수 부분만 출력
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int missCnt = 0;
            int cnt = 0;
            while (true) {
                String str = br.readLine();

                if (str.length() == 0) {
                    break;
                }

                cnt += str.length();
                for (char ch : str.toCharArray()) {
                    if (ch == '#') {
                        missCnt++;
                    }
                }
            }

            double ratio = ((double) (cnt - missCnt)) / cnt * 100;
            ratio = Math.round(ratio * 10) / 10.0;
            sb.append("Efficiency ratio is ")
                .append(ratio == (double) ((int) ratio) 
                    ?  (int) ratio 
                    : String.format("%.1f", ratio))
                .append("%.\n");
        }

        System.out.println(sb);
    }
}
