package src.baekjoon.complexity.data_structure.linkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LinkedList2840 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Character[] arr = new Character[N];
        Set<Character> set = new HashSet<>();
        int index = 0;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < arr.length; i++) {
            arr[i] = '?';
        }

        for (int i = 0; i < K; i++) {
            String[] command = br.readLine().split(" ");
            int changeCount = Integer.parseInt(command[0]);
            char alphabet = command[1].charAt(0);
            if (i != 0) {
                index += changeCount;
            }
            if (index >= arr.length) {
                while (index >= arr.length) {
                    index -= arr.length;
                }
            }
            if (arr[index] != '?' && arr[index] != alphabet) {
                sb.append("!");
                break;
            }
            set.add(alphabet);
            arr[index] = alphabet;
        }


        if (sb.toString().equals("")) {
            for (int i = 0; i < N; i++) {
                if(arr[i] == '?') continue;
                if(set.contains(arr[i])) {
                    set.remove(arr[i]);
                }else {
                    sb.append("!");
                    break;
                }
            }
        }


        if (sb.toString().equals("")) {
            int i = 0;
            while (i != N) {
                if (arr[index] != null) {
                    sb.append(arr[index]);
                } else {
                    sb.append("?");
                }

                if (index > 0) {
                    index--;
                } else {
                    index = N - 1;
                }
                i++;
            }
        }

        System.out.println(sb.toString());
    }
}
