import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int[][] adj = new int[][] { { 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        topologicalSort(adj, visited, stack, 0);

        while (!stack.isEmpty()) {
            System.out.println("" + stack.removeFirst());
        }
    }

    public static void topologicalSort(int[][] adj, Set<Integer> visited, Deque<Integer> stack, int ptr) {
        visited.add(ptr);
        for (int i = 0; i < adj[0].length; i++) {
            if (adj[ptr][i] == 1 && !visited.contains(i))
                topologicalSort(adj, visited, stack, i);
        }
        stack.addFirst(ptr);
    }
}
