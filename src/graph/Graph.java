package graph;

import java.util.*;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    private boolean isDirected;

    @SuppressWarnings("unchecked")
    public Graph(int V,boolean isDirected) {
        this.V = V;
        this.isDirected=isDirected;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addNode(int v, int w) {
        if (v >= 0 && v < V && w >= 0 && w < V) {
            adj[v].add(w);
            if(!isDirected){
            adj[w].add(v);
            }
        }
    }

    private void dfsUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n]) {
                dfsUtil(n, visited);
            }
        }
    }

    private  void dfsUtil(int v,boolean visited[],ArrayList<Integer> topological){
        visited[v]=true;
        for (int n : adj[v]) {
            if (!visited[n]) {
                dfsUtil(n, visited,topological);
            }
        }
        topological.add(v);
    }

    public void dfs(int v) {
        boolean visited[] = new boolean[this.V];
        dfsUtil(v, visited);
        System.out.println();
    }

    public int numberOfConnectedComponenets() {
        int count = 0;
        boolean visited[] = new boolean[this.V];
        for (int i = 0; i < this.V; i++) {
            if (!visited[i]) {
                count++;
                dfsUtil(i, visited);
            }
        }
        return count;
    }

    public ArrayList<Integer> topologicalSorting() {
        if(!isDirected)return null;
       ArrayList<Integer> topological =new ArrayList<>();
        boolean visited[] = new boolean[this.V];
        for(int i=0;i<this.V;i++){
            if(!visited[i]) dfsUtil(i,visited,topological);
        }
        Collections.reverse(topological);
         return  topological;
    }
}