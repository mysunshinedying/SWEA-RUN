package ETC.SWEA1952;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer priceST = new StringTokenizer(br.readLine());
            StringTokenizer monthST = new StringTokenizer(br.readLine());

            int[] price = new int[4]; //이용권은 네개
            int[] months = new int[13]; //13으로 해서 걍 쉽게 셀거임..

            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(priceST.nextToken());
            }//이용권 가격 추가 끝

            int useMonths = 0;

            for (int i = 1; i <= 12; i++) {
                months[i] = Integer.parseInt(monthST.nextToken());
                if(months[i] > 0) useMonths++;
            } //이용일 추가 끝

            int min = 3000;
            min = Math.min(min, price[3]); //1년치이므로 곱셈X
            //1달권과 1일권을 대결해본다...

            int[] monthPrices = new int[13];
            int[] threePrices = new int[13]; //3달치 추가
            int monthMin = 0;
            for (int i = 0; i < months.length; i++) {
                if(months[i] <= 0) continue; //0이면 세지 않음

                monthPrices[i] = Math.min(months[i] * price[0], price[1]);
                monthMin += Math.min(months[i] * price[0], price[1]);
            }

            min = Math.min(min, monthMin);

            //DP식
            for (int i = 1; i <= 12; i++) {
                if(months[i] <= 0) {
                    threePrices[i] = threePrices[i - 1];
                    continue;
                }

                threePrices[i] = threePrices[i - 1] + monthPrices[i];
                if(i >= 3) threePrices[i] = Math.min(threePrices[i], threePrices[i - 3] + price[2]);

                threePrices[i] = Math.min(threePrices[i], price[3]);

            }

            min = Math.min(min, threePrices[12]);;

            sb.append("#").append(test_case).append(" ").append(min).append("\n");

        }

        System.out.print(sb.toString());
    }
}
