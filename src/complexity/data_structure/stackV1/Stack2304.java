package src.complexity.data_structure.stackV1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stack2304 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int maxPosition = 0;
        int maxHeight = 0;
        int area = 0;

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int position = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            arr[position] = height;
            if(height > maxHeight) {
                maxHeight = height;
                maxPosition = position;
            }
        }

        int currentMaxHeight = 0;
        for(int i = 1; i <= maxPosition; i++) {
            if(arr[i] > currentMaxHeight) {
                currentMaxHeight = arr[i];
            }
            area += currentMaxHeight;
        }

        currentMaxHeight = 0;
        for(int i = arr.length -1 ; i > maxPosition; i--) {
            if(arr[i] > currentMaxHeight) {
                currentMaxHeight = arr[i];
            }
            area += currentMaxHeight;
        }
        System.out.println(area);
    }
}
