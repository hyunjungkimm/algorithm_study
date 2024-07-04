package src.baekjoon.complexity.data_structure.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedList1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuffer result = new StringBuffer();
        result.append("<");
        int index = K;
        while(!list.isEmpty()) {
            if(list.size() >= index) {
                int indexValue = list.remove(index - 1);
                result.append(indexValue);
                index += K - 1;
            } else {
                while(list.size() < index) {
                    index -= list.size();
                }
                int indexValue = list.remove(index - 1);
                result.append(indexValue);
                index += K -1;
                }

                if(list.size() != 0) {
                    result.append(", ");
                }

        }


        result.append(">");
        System.out.println(result);
    }
}
