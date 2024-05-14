package src.complexity.greedy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < N; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if(map.get(key) == null) {
                map.put(key, value);
            } else {
                map.put(key, Math.min(map.get(key),value));
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));

        int preValue = 0;
        for (Integer key : keySet) {
            int value = map.get(key);
            if(preValue <= key) {
                preValue = value;
                count++;
            }
//            System.out.print("Key : " + key);
//            System.out.println(", Val : " + map.get(key));
        }


        System.out.println(count);

    }
}
