package src.programmers.hash;

import java.util.*;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) break;
        }

        return participant[i];
    }

    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (String name : participant) {
            if (map.get(name) > 0) answer = name;
        }

        return answer;
    }
}
