import   graph.*;
public class Main {
    public static void main(String[] args) {
   Graph g =new Graph(10);
    g.addNode(1,6);
    g.addNode(2,4);
    g.addNode(8,4);
    g.addNode(6,4);
    g.addNode(9,3);
    g.addNode(1,3);
    g.dfs(1);
    }
}