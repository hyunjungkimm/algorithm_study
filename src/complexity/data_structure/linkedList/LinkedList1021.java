package src.complexity.data_structure.linkedList;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedList1021 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        String[] getNums = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int result = 0;

        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        for(int i = 0; i < getNums.length; i++){
            int getNum = Integer.parseInt(getNums[i]);
            while(true) {
                if(getNum == list.getFirst()){
                    list.removeFirst();
                    N--;
                    break;
                } else {
                    int index = list.indexOf(getNum);
                    if(index > N /2){
                        list.addFirst(list.removeLast());
                        result++;
                    } else {
                        list.addLast(list.removeFirst());
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
