package src.leetcode.DFS_BFS;

import java.util.*;

class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            list.add(new ArrayList());
        }

        for(int[] num : prerequisites) {
            list.get(num[1]).add(num[0]);
        }

        for(int i = 0; i < list.size(); i++) {
            if(visited[i] == 0) {
                if(dfs(i, list, visited)){
                    return false;
                }
            }
        }
        return true;

    }

    public boolean dfs(int course, List<List<Integer>> list, int[] visited) {
        if(visited[course] == 1) {
            return true;
        }
        if(visited[course] == 2) {
            return false;
        }

        visited[course] = 1;

        for(int num : list.get(course)) {
            if(dfs(num, list, visited)) {
                return true;
            }
        }

        visited[course] = 2;
        return false;

    }
}
