package D1.SWEA21936;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String str = br.readLine(); // 세팅 종료

            //일부 문자열이라는 걸 잊었네 :)
            // 그럼 자기 자신이 중심이 되는 중심에서 시작. (X)
            // 자신에게서 M -1(자기자신이 포함되므로)까지 잘라서 회문 검사를 할것
            // 밖에서 진행해도 OK이므로.

            //또 toCharArray 잊어서 다음에는 꼭 하기로 ㅠㅠ..

            int idx = -1;

            for (int i = 0; i < N - M + 1; i++) {
                boolean itsPal = true;
                for (int j = 0; j < M / 2; j++) {
                    if(str.charAt(i + j) != str.charAt((i + M - 1 - j))){
                        itsPal = false;
                        break;
                    }
                }
                if(itsPal) {
                    idx = i;
                    break;
                }
            }


            sb.append("#").append(test_case).append(" ");

            if(idx >= 0) {
                sb.append(str.substring(idx, idx + M));
            } else {
                sb.append("NONE");
            }

            sb.append("\n");


        } // 테스트 케이스

        System.out.print(sb.toString());
    }
}
