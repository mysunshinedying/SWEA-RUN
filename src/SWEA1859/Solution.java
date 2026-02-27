package SWEA1859;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            //테스트 케이스 시작

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            //로또번호를 사는게 더 낫지 않았을까 원재야
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 테스트케이스 문제...??가??
            long money = 0;
            long current = 0;

            for (int i = N - 1; i >= 0; i--) {
                //떨어지기 직전에 매매해야한다!
                //끝에서부터 세는 쪽이 낫다

                // 점점 커지면 0.
                // 점점 작아지면 ++
                // 자기보다 작아지다가 커지면 그때 2 - 1 이런느낌이군..?

                if(current < arr[i]){
                    current = arr[i];
                } else {
                    money += current - arr[i];
                }

            }

            System.out.printf("#%d %d%n", test_case, money);


        }

    }
}