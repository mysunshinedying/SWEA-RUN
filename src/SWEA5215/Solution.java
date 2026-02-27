package SWEA5215;

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
            // 재료의 수
            int N = Integer.parseInt(st.nextToken());
            // 제한 칼로리
            int L = Integer.parseInt(st.nextToken());

            int[] scores = new int[N];
            int[] calories = new int[N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                //민기의 점수, 칼로리
                scores[i] = Integer.parseInt(st2.nextToken());
                calories[i] = Integer.parseInt(st2.nextToken());
            }
            // 점수 및 칼로리 추가 완료
            int[] arr = new int[L + 1];

            // 칼로리별 점수
            // 1000(L)에서 역산함
            // 우리에게 중요한 건 scores라는것
            // 현재 칼로리에 따른 scores 배열은 준비되어 있음
            // 즉 arr[1000(L)]부터 연산하면서, 각 재료에 따른 scores와 calories를 지킬 것

            for(int i = 0; i < N; i++){
                //이번 재료를 투하
                int kal = calories[i];
                int score = scores[i];

                // L, 즉 1000에서 역산.(첫번째 케이스)
                //arr[j]< 1000의 경우
                //arr[1000]과, arr[j - kal] + score를 비교하면서 내려감
                //지금의 조합과 해당 칼로리에 지금 재료를 뺀 score값에 score값을 얹을 때
                // 더 큰지에 대해서 비교하는 것.
                // 이렇게 하다보면 더 높은 점수로 해당 칼로리에 쌓여간다
                for(int j = L; j >= kal; j--){
                    arr[j] = Math.max(arr[j], arr[j - kal] + score);
                }

            }
            System.out.printf("#%d %d%n",test_case, arr[L]);

        }

    }
}
