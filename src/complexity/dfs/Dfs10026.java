package src.complexity.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dfs10026 {
    static int N;
    static char[][] arr;
    static boolean [][] visited;
    static boolean [][] redGreenVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;
    static int redGreenCount = 0;

    private static void colorDfs(int x, int y, String color) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >= 0 && cx < N && cy < N) {
                if(!visited[cx][cy]) {
                    switch (color) {
                        case "Green" :
                            if(arr[cx][cy] == 'G')
                                colorDfs(cx, cy, "Green");
                            break;
                        case "Red" :
                            if(arr[cx][cy] == 'R')
                                colorDfs(cx, cy, "Red");
                            break;
                        case "Blue" :
                            if(arr[cx][cy] == 'B')
                                colorDfs(cx, cy, "Blue");
                            break;

                    }
                }
            }
        }
    }

    private static void RedBlueColorDfsBlue(int x, int y, String color) {
        redGreenVisited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >= 0 && cx < N && cy < N) {
                if(!redGreenVisited[cx][cy]) {
                    switch (color) {
                        case "Blue" :
                            if(arr[cx][cy] == 'B')
                                RedBlueColorDfsBlue(cx, cy, "Blue");
                            break;
                        default:
                            if(arr[cx][cy] == 'R' || arr[cx][cy] == 'G')
                                RedBlueColorDfsBlue(cx, cy, "RG");
                            break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                arr[i][j] = line[j];
            }
        }
        visited = new boolean[N][N];
        redGreenVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    switch(arr[i][j]) {
                        case 'G':
                            colorDfs(i, j, "Green");
                            count++;
                            break;
                        case 'R':
                            colorDfs(i, j, "Red");
                            count++;
                            break;
                        case 'B':
                            colorDfs(i, j, "Blue");
                            count++;
                            break;

                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!redGreenVisited[i][j]) {
                    switch(arr[i][j]) {
                        case 'B':
                            RedBlueColorDfsBlue(i, j, "Blue");
                            redGreenCount++;
                            break;
                        case 'G':
                            RedBlueColorDfsBlue(i, j, "RG");
                            redGreenCount++;
                            break;
                        case 'R':
                           RedBlueColorDfsBlue(i, j, "RG");
                           redGreenCount++;
                           break;
                    }
                }
            }
        }



        System.out.print(count +" ");
        System.out.println(redGreenCount);
    }
}
