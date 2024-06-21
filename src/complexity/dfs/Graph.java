package src.complexity.dfs;

import java.util.*;

public class Graph<T>{
    private Map<T, List<T>> adjVertx;
    private Set<T> visited = new HashSet<>();

    public Graph() {
        adjVertx = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjVertx.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(T vertex1, T vertex2) {
        adjVertx.get(vertex1).add(vertex2);
        adjVertx.get(vertex2).add(vertex1);
    }

    public List<T> getNeighbors(T vertex) {
        return adjVertx.get(vertex);
    }

    // dfs - 재귀
    public void dfsRecursive(T start) {
        if(!visited.contains(start)) {
            System.out.print(start+ " ");
            visited.add(start);
            for(T neighbor : getNeighbors(start)) {
                dfsRecursive(neighbor);
            }
        }
    }

    //dfs - stack
    public void dfsIterative(T start) {
        Stack<T> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()) {
            T vertex = stack.pop();
            if(!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " ");
                for (T neighbor : getNeighbors(vertex)) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");

        System.out.println("Recursive DFS : ");
        graph.dfsRecursive("A");

        Graph<String> graph2 = new Graph<>();
        graph2.addVertex("A");
        graph2.addVertex("B");
        graph2.addVertex("C");
        graph2.addVertex("D");
        graph2.addVertex("E");

        graph2.addEdge("A", "B");
        graph2.addEdge("A", "C");
        graph2.addEdge("B", "D");
        graph2.addEdge("C", "D");
        graph2.addEdge("C", "E");
        graph2.addEdge("D", "E");

        System.out.println("\nIterative DFS : ");
        graph2.dfsIterative("A");
    }
}
