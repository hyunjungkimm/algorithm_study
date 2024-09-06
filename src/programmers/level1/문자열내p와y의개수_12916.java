package src.programmers.level1;
/**
 * Author    : 김현정
 * Date      : 2024.09.06(금)
 * Runtime   :
 * Memory    :
 * Algorithm : [프로그래머스]LV1 - 12916 문자열 내 p와 y의 개수
 */
class 문자열내p와y의개수_12916 {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        s = s.toLowerCase();

        char[] arr = s.toCharArray();

        for(char a : arr) {
            if(a == 'p') {
                pCount++;
            }else if(a == 'y') {
                yCount++;
            }
        }

        return pCount==yCount;
    }
}
