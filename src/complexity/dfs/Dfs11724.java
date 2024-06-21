package src.complexity.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dfs11724 {
    private static class Graph {
        private Map<String, List<String>> adjVertex;
        private Set<String> visited = new HashSet<>();

        public Graph() {
            adjVertex = new HashMap<>();
        }

        public void addVertex(String vertex) {
            adjVertex.putIfAbsent(vertex, new ArrayList<>());
        }

        public void addEdge(String vertex1, String vertex2) {
            adjVertex.get(vertex1).add(vertex2);
            adjVertex.get(vertex2).add(vertex1);
        }

        public List<String> getAdjVertex(String vertex) {
            return adjVertex.get(vertex);
        }

        //dfs - 재귀
        public void dfsRecursive(String start) {
            if(!visited.contains(start)) {
                visited.add(start);

                for(String neighbor : adjVertex.get(start)) {
                    dfsRecursive(neighbor);
                }

            }
        }

        //dfs - iterative
        public void dfsIterative(String start) {
            Stack<String> stack = new Stack<>();
            stack.push(start);

            while(!stack.isEmpty()) {
                String vertex = stack.pop();
                if(!visited.contains(vertex)) {
                    visited.add(vertex);
                    for(String neighbor : adjVertex.get(vertex)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] graphElement = br.readLine().split(" ");
        int N = Integer.parseInt(graphElement[0]);
        int M = Integer.parseInt(graphElement[1]);
        int count = 0;
        Graph graph = new Graph();

        for(int i = 1; i <= N; i++) {
            graph.addVertex(String.valueOf(i));
        }

        for(int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            graph.addEdge(edge[0], edge[1]);
        }

        for(int i = 1; i <= N; i++) {
            if(!graph.visited.contains(String.valueOf(i))) {
                //graph.dfsRecursive(String.valueOf(i));
                graph.dfsIterative(String.valueOf(i));
                count++;
            }
        }
        System.out.println(count);
    }
}
