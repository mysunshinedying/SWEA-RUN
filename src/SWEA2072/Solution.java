package SWEA2072;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            //테스트 케이스 시작
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = 10;
            int answer = 0;

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 1) { answer += num; }
            }

            System.out.printf("#%d %d%n", test_case, answer);


        }

    }
}
