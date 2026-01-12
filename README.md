# Graph Algorithms Implementation

A comprehensive Java implementation of fundamental graph algorithms including DFS traversal, cycle detection, topological sorting, and connected components analysis.

## Features

- **Graph Representation**: Adjacency list-based graph structure
- **Support for Both**: Directed and undirected graphs
- **Depth-First Search (DFS)**: Recursive traversal implementation
- **Cycle Detection**: Identifies cycles in directed graphs using DFS with backtracking
- **Topological Sorting**: Generates valid ordering for DAGs (Directed Acyclic Graphs)
- **Connected Components**: Counts separate components in undirected graphs

## Class Structure

### Graph.java

The main `Graph` class provides the following functionality:

#### Constructor
```java
Graph(int V, boolean isDirected)
```
- `V`: Number of vertices in the graph
- `isDirected`: `true` for directed graph, `false` for undirected

#### Methods

**addNode(int v, int w)**
- Adds an edge from vertex `v` to vertex `w`
- For undirected graphs, automatically adds edge in both directions

**dfs(int v)**
- Performs depth-first search starting from vertex `v`
- Prints visited nodes in DFS order

**numberOfConnectedComponenets()**
- Returns the count of connected components in the graph
- Useful for undirected graphs

**topologicalSorting()**
- Returns an `ArrayList<Integer>` with vertices in topological order
- Returns `null` for undirected graphs or graphs with cycles
- Uses DFS-based approach

**detectCycle()**
- Returns `true` if the directed graph contains a cycle
- Returns `false` if the graph is a DAG
- Uses DFS with recursion stack tracking

## Algorithm Complexity

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Add Edge | O(1) | O(1) |
| DFS | O(V + E) | O(V) |
| Cycle Detection | O(V + E) | O(V) |
| Topological Sort | O(V + E) | O(V) |
| Connected Components | O(V + E) | O(V) |

Where V = number of vertices, E = number of edges

## Usage Examples

### Example 1: Undirected Graph with Connected Components

```java
Graph star = new Graph(5, false);
star.addNode(0, 1);
star.addNode(0, 2);
star.addNode(0, 3);
star.addNode(0, 4);

int components = star.numberOfConnectedComponenets(); // Returns 1
```

### Example 2: Directed Acyclic Graph (DAG) - Topological Sort

```java
Graph dag = new Graph(6, true);
dag.addNode(5, 2);
dag.addNode(5, 0);
dag.addNode(4, 0);
dag.addNode(4, 1);
dag.addNode(2, 3);
dag.addNode(3, 1);

ArrayList<Integer> order = dag.topologicalSorting();
// Returns valid topological order: [5, 4, 2, 3, 1, 0] or similar
```

### Example 3: Cycle Detection

```java
Graph cyclic = new Graph(3, true);
cyclic.addNode(0, 1);
cyclic.addNode(1, 2);
cyclic.addNode(2, 0);

boolean hasCycle = cyclic.detectCycle(); // Returns true
```

## Test Cases Included

The `Main.java` file includes comprehensive test cases:

1. **Undirected Star Graph**: Tests connected components on a star-shaped graph
2. **Disconnected Islands**: Tests multiple separate components
3. **Directed DAG**: Tests topological sorting on acyclic directed graph
4. **Simple Cycle**: Tests cycle detection on a basic 3-node cycle
5. **Complex Graph**: Tests cycle detection on larger graphs with hidden cycles
6. **Disconnected Cycle**: Tests cycle detection across disconnected components

## Running the Code

1. Ensure both `Graph.java` and `Main.java` are in the correct package structure:
   ```
   src/
   ├── graph/
   │   └── Graph.java
   └── Main.java
   ```

2. Compile the code:
   ```bash
   javac graph/Graph.java Main.java
   ```

3. Run the test suite:
   ```bash
   java Main
   ```

## Key Algorithms Explained

### Cycle Detection Algorithm

The cycle detection uses DFS with three states:
- **White (unvisited)**: Node hasn't been explored
- **Gray (in recursion stack)**: Node is being processed
- **Black (visited)**: Node and all descendants are processed

A cycle exists if we encounter a gray node during DFS traversal.

### Topological Sorting Algorithm

Uses DFS to process nodes and adds them to the result list after all descendants are processed. This ensures dependencies come before dependents in the final ordering.

### Connected Components Algorithm

Performs DFS from each unvisited node, incrementing the component counter for each new starting point. All nodes reached in a single DFS belong to the same component.

## Notes

- Topological sorting only works on directed acyclic graphs (DAGs)
- Attempting topological sort on a graph with cycles returns `null`
- Connected components counting is primarily meaningful for undirected graphs
- Vertex indices must be in range [0, V-1]
