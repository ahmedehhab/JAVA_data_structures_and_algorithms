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

        // --- TEST CASE 3: Directed DAG (No Cycle) ---
        System.out.println("--- Test Case 3: Directed DAG ---");
        // Structure: 5 -> 2 -> 3, 5 -> 0, 4 -> 0, 4 -> 1
        Graph dag = new Graph(6, true);
        dag.addNode(5, 2);
        dag.addNode(5, 0);
        dag.addNode(4, 0);
        dag.addNode(4, 1);
        dag.addNode(2, 3);
        dag.addNode(3, 1);

        System.out.print("Topological Sorting Order: ");
        ArrayList<Integer> result = dag.topologicalSorting();
        if (result != null) {
            for (int node : result) {
                System.out.print(node + " ");
            }
        } else {
            System.out.print("Cycle detected (Null)");
        }
        System.out.println("\nHas Cycle? (Should be false): " + dag.detectCycle());
        System.out.println();

        // --- TEST CASE 4: Simple Directed Cycle ---
        System.out.println("--- Test Case 4: Directed Cycle (0 -> 1 -> 2 -> 0) ---");
        Graph cyclic = new Graph(3, true);
        cyclic.addNode(0, 1);
        cyclic.addNode(1, 2);
        cyclic.addNode(2, 0);

        System.out.println("Has Cycle? (Should be true): " + cyclic.detectCycle());
        System.out.println();

        // --- TEST CASE 5: Complex Graph with 1 Cycle ---
        System.out.println("--- Test Case 5: Large Graph with one hidden cycle ---");
        Graph complex = new Graph(5, true);
        complex.addNode(0, 1);
        complex.addNode(1, 2);
        complex.addNode(2, 3);
        complex.addNode(0, 4);
        complex.addNode(3, 1); // Cycle: 1 -> 2 -> 3 -> 1

        System.out.println("Has Cycle? (Should be true): " + complex.detectCycle());
        System.out.println();

        // --- TEST CASE 6: Disconnected Cycle ---
        System.out.println("--- Test Case 6: Disconnected Cycle ---");
        Graph disconnectedCycle = new Graph(4, true);
        disconnectedCycle.addNode(0, 1); // Component 1 (No cycle)
        disconnectedCycle.addNode(2, 3); // Component 2 (Cycle start)
        disconnectedCycle.addNode(3, 2); // Component 2 (Cycle end)

        System.out.println("Has Cycle? (Should be true): " + disconnectedCycle.detectCycle());
    }
}