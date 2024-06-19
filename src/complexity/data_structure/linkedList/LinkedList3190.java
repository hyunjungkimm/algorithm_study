package src.complexity.data_structure.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedList3190 {
    static Queue<Integer> right = new LinkedList<>();
    static Queue<Integer> left = new LinkedList<>();
    static int second = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[N+3][N+3];
        boolean[][] existingApple = new boolean[N+3][N+3];
        Queue<String> queue = new LinkedList<>();

        int K = Integer.parseInt(br.readLine());
        for(int i = 1; i <= K; i++) {
            String[] isApple = br.readLine().split(" ");
            int row = Integer.parseInt(isApple[0]);
            int col = Integer.parseInt(isApple[1]);
            existingApple[row][col] = true;
        }

        int L = Integer.parseInt(br.readLine());
        for(int i = 1; i <= L; i++) {
            String[] isApple = br.readLine().split(" ");
            int second = Integer.parseInt(isApple[0]);
            String direction = isApple[1];
            if(direction.equals("D")) right.add(second);
            else left.add(second);
        }

        int row = 1;
        int col = 1;
        String direction = "right";
        visited[row][col] = true;
        int tailRow = 1;
        int tailCol = 1;
        queue.add(direction);

        while(true) {
            second++;
            switch(direction) {
                case "right" :
                    col ++;
                    break;
                case "left" :
                    col--;
                    break;
                case "up" :
                    row--;
                    break;
                case "down" :
                    row++;
                    break;
            }

            if(row > N || col > N || row < 1 || col < 1){
                break;
            }

            if(visited[row][col]) {
                break;
            }

            if(existingApple[row][col]) {
                existingApple[row][col] = false;
                visited[row][col] = true;
                queue.add(direction);
            } else {
                queue.remove();
                visited[row][col] = true;
                queue.add(direction);
                visited[tailRow][tailCol] = false;
                String next = queue.peek();
                switch(next) {
                    case "right" :
                        tailCol++;
                        break;
                    case "left" :
                        tailCol--;
                        break;
                    case "up" :
                        tailRow--;
                        break;
                    case "down" :
                        tailRow++;
                        break;
                }
            }
            direction = Direction(direction);

        }

        System.out.println(second);

    }

    private static String Direction(String direction) {
        if(right.contains(second)) {
            switch(direction) {
                case "right" :
                    direction = "down";
                    break;
                case "down" :
                    direction = "left";
                    break;
                case "left" :
                    direction = "up";
                    break;
                case "up" :
                    direction = "right";
                    break;
            }
            right.remove(second);
        }

        if(left.contains(second)) {
            switch(direction) {
                case "right" :
                    direction = "up";
                    break;
                case "down" :
                    direction = "right";
                    break;
                case "left" :
                    direction = "down";
                    break;
                case "up" :
                    direction = "left";
                    break;
            }
            left.remove(second);
        }
        return direction;
    }
}
