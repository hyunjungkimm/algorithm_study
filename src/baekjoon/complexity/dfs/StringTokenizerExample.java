package src.baekjoon.complexity.dfs;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        String str = "Hello World This Is StringTokenizer Example";

        //기본 구분자(공백, 탭, 줄바꿈)를 사용하여 문자열을 분할
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        System.out.println();

        // 지정된 구분자 ','를 사용하여 문자열을 분할
        String str2 = "Apple,Orange,Banana,Grapes";
        StringTokenizer st2 = new StringTokenizer(str2, ",");
        while(st2.hasMoreTokens()) {
            System.out.println(st2.nextToken());
        }

        System.out.println();

        //지정된 구분자 ','를 사용하여 문자열을 분할하고, 구분자를 토큰으로 반환
        StringTokenizer st3 = new StringTokenizer(str2, ",", true);
        while(st3.hasMoreTokens()) {
            System.out.println(st3.nextToken());
        }

    }
}
