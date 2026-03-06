package D3.SWEA2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            char[][] arr = new char[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                arr[i] = str.toCharArray();
            }

            int l = N / 2; //가운데 기준
            int total = 0;

            //total += arr[i][center] - '0';
            //                total += arr[center][i] - '0';
            //                total -= arr[center][center] - '0'; //겹쳐지는 것 제외

            for (int i = 0; i < N; i++) {
                //0번째는 center만
                //1번째는 center -1 center center + 1
                //2번째는 center -2 center ...
                //3번째는 center -1 center center +1..

                //투포인트 방식인건 확실한뎁..
                // 자신과 자신으로부터 멀리있는..!! 근데
                //자신을 중심으로 잡아서왼오를 시작하는 방식같다!!center 정했으니까..
                // l이 시작점이고.. i가 기준이 되어서.. 빼고 더한다.
                // 거기서 for문을 돌려서, 더한다!
                // l - i .. l - 1 l l + 1 .. l + i 이런형태로.. 1 + 2 * i
                    for (int j = 0; j < N; j++) {
                        // 절대값 메서드를 자꾸 잊어버린다. 최적화
                        if (Math.abs(i - l) + Math.abs(j - l) <= l) {
                            total += arr[i][j] - '0';
                        }
                }
            }

            sb.append("#").append(test_case).append(" ").append(total).append("\n");


        }

        System.out.print(sb.toString());

    }
}
