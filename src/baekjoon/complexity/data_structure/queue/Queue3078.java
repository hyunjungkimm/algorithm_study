package src.baekjoon.complexity.data_structure.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Queue3078 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Queue<Integer>[] queue = new LinkedList[22];
        Integer[] arr = new Integer[N];
        long result = 0;


        for(int i = 0; i < N; i++){
            String name = br.readLine();
            arr[i] = name.length();
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            while(count <= i+K && count < arr.length) {
                if(queue[arr[count]] == null) {
                    queue[arr[count]] = new LinkedList<>();
                }
                queue[arr[count]].add(arr[count]);
                count++;
            }
            queue[arr[i]].poll();
            result += queue[arr[i]].size();
        }

        System.out.println(result);
    }
}
