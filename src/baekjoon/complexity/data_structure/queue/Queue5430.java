package src.baekjoon.complexity.data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Queue5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String direction;
        Boolean isError;

        for (int i = 0; i < T; i++) {
            isError = false;
            direction = "front";
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine()
                    .replaceAll("[\\[\\]]","")
                    .split(",");
            Deque<Integer> queue = new LinkedList<>();

            for(int j = 0; j < n; j++){
                queue.add(Integer.parseInt(arr[j]));
            }

            for(int j = 0; j < p.length; j++){
                switch(p[j]) {
                    case 'R' :
                        if(direction.equals("rear")){
                            direction = "front";
                        }else {
                            direction = "rear";
                        }
                        break;
                    case 'D' :
                        if(queue.isEmpty()){
                            isError = true;
                            break;
                        }else {
                            if(direction.equals("rear")){
                                queue.removeLast();
                            }else{
                                queue.removeFirst();
                            }
                        }
                }
            }

            if(!isError){
                StringBuffer sb = new StringBuffer();
                while(!queue.isEmpty()){
                    if(sb.length() > 0){
                        sb.append(",");
                    }
                    if(direction.equals("rear")){
                        sb.append(queue.removeLast());
                    }else{
                        sb.append(queue.removeFirst());
                    }
                }
                System.out.println(String.format("[%s]", sb));
            }else {
                System.out.println("error");
            }
        }
    }
}
