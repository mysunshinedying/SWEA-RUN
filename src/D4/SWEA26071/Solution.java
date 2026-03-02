package D4.SWEA26071;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution {
    static int maxScore = 0;
    // 상수선언요..??왜요??ㅠㅠ
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            // 각 테스트 케이스 시작
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            //ArrayList 사용이 좋을듯?

            maxScore = 0;
            blockRemove(list,0);

            System.out.printf("#%d %d%n", test_case, maxScore);
        }
    }

    static void blockRemove(ArrayList<Integer> list, int max){
        // 재귀요..?왜요..?ㅠㅠ
        //지워둔 로직 다행히 재활용가능했음 ㅠㅠㅋㅋ 슬프다..

        if(list.size() == 1){
            max += list.get(0);
            maxScore = Math.max(maxScore, max);
            return;
        }

        for(int i = 0; i < list.size(); i++){
            // 0이 아니라 1부터 시작해야함
            // 경계값(1)
            int left = 1, right = 1;

            if(i - 1 >= 0) { left = list.get(i - 1); }
            if(i + 1 < list.size()) { right = list.get(i + 1); }
            int score = left * right;

            //remove한거 저장해둘 수 있었구나..
            //생각해보니까 js에서도 비슷한거 있었구만,,
            // 이부분은 약간의 도움을 빌림
            int removed = list.remove(i);
            blockRemove(list, max + score);
            list.add(i, removed);

        }

    }

}
