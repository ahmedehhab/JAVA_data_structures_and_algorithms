package graph;

import java.util.LinkedList;

public class Graph {
 private  int V ; // number of vertices
    private LinkedList<Integer> adj[];

   public  Graph(int V){
       this.V=V;
       adj=new LinkedList[V];
       for(int i=0;i<V;i++){
           adj[i]=new LinkedList();
       }
   }

   public void addNode(int v,int w){
       adj[v].add(w);
       adj[w].add(v);

   }

   private void DfsUtil(int v ,boolean visited[]){
       visited[v]=true;
       System.out.println(v);
       for(int n:adj[v]){
           if(!visited[n]) DfsUtil(n,visited);
       }
   }

   public  void dfs(int v){
       boolean visited[]=new boolean[this.V];
       DfsUtil(v,visited);
   }


}
