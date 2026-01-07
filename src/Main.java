import graph.Graph;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // --- TEST CASE 1: Undirected Star Graph ---
        System.out.println("--- Test Case 1: Undirected Star ---");
        Graph star = new Graph(5, false);
        star.addNode(0, 1);
        star.addNode(0, 2);
        star.addNode(0, 3);
        star.addNode(0, 4);

        System.out.println("Connected Components (Should be 1): " + star.numberOfConnectedComponenets());
        // Topological sort should return null for undirected
        System.out.println("Topological Sort (Should be null): " + star.topologicalSorting());
        System.out.println();

        // --- TEST CASE 2: Disconnected Islands ---
        System.out.println("--- Test Case 2: Disconnected Islands ---");
        Graph islands = new Graph(6, false);
        islands.addNode(0, 1); // Island 1
        islands.addNode(2, 3); // Island 2
        islands.addNode(4, 5); // Island 3

        System.out.println("Connected Components (Should be 3): " + islands.numberOfConnectedComponenets());
        System.out.println();

        // --- TEST CASE 3: Directed Dependency Graph ---
        System.out.println("--- Test Case 3: Directed DAG ---");
        // Structure: 5 -> 2 -> 3, 5 -> 0, 4 -> 0, 4 -> 1
        Graph dag = new Graph(6, true);
        dag.addNode(5, 2);
        dag.addNode(5, 0);
        dag.addNode(4, 0);
        dag.addNode(4, 1);
        dag.addNode(2, 3);
        dag.addNode(3, 1);

        System.out.println("Topological Sorting Order:");
        ArrayList<Integer> result = dag.topologicalSorting();
        if (result != null) {
            for (int node : result) {
                System.out.print(node + " ");
            }
        }
        System.out.println("\n(One valid order: 5 4 2 3 1 0)");
    }
}