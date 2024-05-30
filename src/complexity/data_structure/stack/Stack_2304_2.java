package src.complexity.data_structure.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stack_2304_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int maxPos = 0;
        int maxHeight = 0;
        int area = 0;

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int pos = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            arr[pos] = height;
            if(maxHeight < height) {
                maxHeight = height;
                maxPos = pos;
            }
        }

        int thisMaxHeight = 0;
        for(int i = 0; i <= maxPos; i++) {
            if(thisMaxHeight < arr[i]) {
                thisMaxHeight = arr[i];
            }
            area += thisMaxHeight;
        }

        thisMaxHeight = 0;
        for(int i = 1000; i > maxPos; i--) {
            if(thisMaxHeight < arr[i]) {
                thisMaxHeight = arr[i];
            }
            area += thisMaxHeight;
        }

        System.out.println(area);
    }
}