package Baekjoon.Silver.Prob4_3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 좋은 단어 - 실버 4
 * 
 * 좋은 단어르 찾기
 *  좋은 단어 - 글자끼리 (A는 A끼리, B는 B끼리) 쌍을 짓기로함
 *  만약 선끼리 교차하지 않으면서 각 글자를 정확히
 *  한 개의 다른 위치에 있는 같은 글자와 짝 지을 수 있다면
 *  그 단어는 '좋은 단어'
 * 
 * 입력
 *  첫째 줄에 단어의 수 N (1 ~ 100)
 *  N개의 줄에 A와 B로만 이루어진 단어가 한 줄에 하나씩 주어짐
 *  단어의 길이는 2와 100,000 사이이며
 *  모든 단어 길이의 합은 1,000,000을 넘지 않음
 * 
 * 출력
 *  좋은 단어의 수 출력
 * 
 * 문제 잘못 이해함
 *  좋은 단어 O)

    A     B     B     A

    |     |___|     |

    |___________|

    좋은 단어 X)

    A     B     A     B

    |___|___|     |

        |_______|  

    이런거였음 stack 써야함
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();

            for (char ch : line.toCharArray()) {
                if (stack.isEmpty() || stack.peek() != ch) {
                    stack.push(ch);
                } else if (stack.peek() == ch) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                ans++;
            }            
        }
        
        System.out.println(ans);
    }
}
