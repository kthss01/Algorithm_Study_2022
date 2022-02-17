package Baekjoon.Silver.Prob3_2992;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 크면서 작은 수 - 실버 3
 * 
 * 정수 x가 주어졌을 때, x와 구성이 같으면서
 * x보다 큰 수 중 가장 작은 수를 출력
 * 
 * 수의 구성이 같다는 말은
 * 수를 이루고 있는 각 자리수가 같다는 뜻
 * ex)
 *  123 321 수의 구성 같음
 *  123 432 수의 수겅 다름
 * 
 * 입력
 *  첫째 줄 X가 주어짐 (1 <= X <= 999999)
 *  X는 0으로 시작하지 않음
 * 
 * 출력
 *  첫째 줄에 결과를 출력
 *  만약 그러한 숫자가 없는 경우 0 출력
 */
public class Main {

    static int[] arr;
    static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String numStr = sc.nextLine();
        n = numStr.length();
        arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = numStr.charAt(i) - '0';
        }

        Arrays.sort(arr);
        int ans = 0;
        do {
            //System.out.println(Arrays.toString(arr));
            int num = makeNum(arr);
            //System.out.println(num);
            if (num > Integer.parseInt(numStr)) {
                ans = num;
                break;
            }
        } while (next_permutation());

        System.out.println(ans);

        sc.close();
    }

    private static int makeNum(int[] arr2) {
        int num = 0;
        for (int i = 0; i < arr2.length; i++) {
            num += arr2[i] * Math.pow(10, arr2.length - i - 1);
        }
        return num;
    }

    private static boolean next_permutation() {
        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            --i;
        }
        if (i == 0) {
            return false;
        }

        int j = n - 1;
        while (arr[i - 1] >= arr[j]) {
            --j;
        }

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        int k = n - 1;
        while (i < k) {
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            ++i;
            --k;
        }

        return true;
    }
}
