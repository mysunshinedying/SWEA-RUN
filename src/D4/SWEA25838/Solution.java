package D4.SWEA25838;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= TC; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringBuilder sb2 = new StringBuilder();

            for(char c : str.toCharArray()){
                sb2.append(c);

                int size = sb2.length();
                if(size >= 3){
                    if(sb2.charAt(size - 3) == 'f'
                    && sb2.charAt(size - 2) == 'o'
                    && sb2.charAt(size - 1) == 'x') {
                        sb2.setLength(size - 3);
                    }
                }
            }


            sb.append("#").append(test_case).append(" ").append(sb2.length()).append("\n");

        }

        System.out.print(sb.toString());
    }
}
