package src.complexity.data_structure.stackV1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack2841 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        int count = 0;

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int line = Integer.parseInt(input[0]);
            int plat = Integer.parseInt(input[1]);

            if(!map.containsKey(line)){
                map.put(line, new Stack<>());
                map.get(line).push(plat);
                count++;
            } else {
                int previous = map.get(line).peek();
                if(previous < plat) {
                    map.get(line).push(plat);
                    count++;
                }
                else if(previous > plat) {
                    while(previous > plat ) {
                        map.get(line).pop();
                        count++;
                        if(map.get(line).size() == 0 ) break;
                        previous = map.get(line).peek();
                    }
                    if(map.get(line).size() == 0 || map.get(line).peek() != plat){
                        map.get(line).push(plat);
                        count++;
                    }
                }
            }

        }

        System.out.println(count);
    }
}
