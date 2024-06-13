package src.complexity.data_structure.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Queue1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int size = Integer.parseInt(input[0]);
            int target = Integer.parseInt(input[1]);
            int result = 0;


            String[] documents = br.readLine().split(" ");
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for(int z = 0; z < documents.length; z++) {
                queue.add(Integer.parseInt(documents[z]));
                priorityQueue.add(Integer.parseInt(documents[z]));
            }

            while(!queue.isEmpty()) {
                if(priorityQueue.peek() == queue.peek()) {
                    if(target == 0) {
                        result++;
                        break;
                    }
                    priorityQueue.poll();
                    queue.poll();
                    result ++;
                    target --;
                }else {
                    queue.add(queue.poll());
                    if(target == 0) {
                        target = queue.size()-1;
                    }else {
                        target --;
                    }
                }
            }

            System.out.println(result);
        }

    }
}
