package D1.SWEA2056;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sb = new StringBuilder();

            // 2중배열로 month와 day를....?
            // ↑ 기존 풀이고 한번 최적화함

            int[] daysMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            //일 추가 완료
            //일 개수만 저장하면 간단해진다.

            //date
            String date = br.readLine();
            boolean isDate = false;

            // String.substring해결법도 있지만 일부러 toChar사용함
            char[] chars = date.toCharArray();

            int month = (chars[4] - '0') * 10 + (chars[5] - '0');
            int day = (chars[6] - '0') * 10 + (chars[7] - '0');


            if (month >= 1 && month <= 12) {
                if (day >= 1 && day <= daysMonth[month]) {
                    isDate = true;
                }
            }

            if (isDate) {
                sb.append(chars[0]).append(chars[1]).append(chars[2]).append(chars[3]).append('/')
                        .append(chars[4]).append(chars[5]).append('/')
                        .append(chars[6]).append(chars[7]);
            } else {
                sb.append("-1");
            }

            System.out.printf("#%d %s%n", test_case, sb.toString());

        }
    }
}
