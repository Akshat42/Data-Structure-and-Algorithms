import java.util.*;
//Adjacency List is implemented using ArrayList.
class AdjacencyList {
    public static int V; //number of vertex
    ArrayList<ArrayList<Integer>> al;
    //constructor
    public AdjacencyList(int V) {
	    this.V = V;
	    al =  new ArrayList<>(V);
	    for(int i=0;i<V;i++) {
		al.add(new ArrayList<Integer>());
	    }
    }
    //for defining edges
    public void addEdge(int u, int v) {
	al.get(u).add(v);
    }
    //prints graph as represented Adjacency List
    public void printGraph() {
	for(int i=0; i<al.size();i++) {
		System.out.print("["+i+"]");
	    for(int j=0; j<al.get(i).size();j++){
		System.out.print("-->"+ al.get(i).get(j));
	    }
	    System.out.println();
	}
    }
}

class BFS {
    int parent[] = new int[AdjacencyList.V];

    public void BreadthFS(int s,AdjacencyList AL) {
	int visited[] = new int[AL.V];
	int level[] = new int[AL.V];
	Queue<Integer> q = new LinkedList<>();
	q.add(s);
	visited[s] = 1;
	parent[s] = -1;//root of BFS tree
	while(q.size() != 0) {
	    int v = q.poll();
	    System.out.print(v+ " ");
	    for(int i=0;i<AL.al.get(v).size();i++) {
		if(visited[AL.al.get(v).get(i)] == 0){
		    level[AL.al.get(v).get(i)]	= level[v] + 1;
		    parent[AL.al.get(v).get(i)] = v;
		    q.add(AL.al.get(v).get(i));
		    visited[AL.al.get(v).get(i)] = 1;
		}
	    } 
	}
	System.out.println();
	System.out.println("Levels of the nodes visited are ");
	for(int i=0;i<level.length;i++)
	    System.out.println(i+" --> " + level[i]);
    }

	public void printShortestPath(int s, int v, AdjacencyList AL){
	    System.out.println("Shortest path from "+v+" to "+s+" is:");
	    System.out.print(v+ " ");
	    int p = parent[v];
	    while(parent[p] != -1) {
		System.out.print(p + " ");
		p = parent[p];
	    }
	    System.out.println(p);

	}		
    public static void main (String args[]) {
	AdjacencyList al = new AdjacencyList(8);
	al.addEdge(0,1);
	al.addEdge(0,3);
	al.addEdge(1,0);
	al.addEdge(1,2);
	al.addEdge(2,1);
	al.addEdge(2,3);
	al.addEdge(3,0);
	al.addEdge(3,2);
	al.addEdge(3,4);
	al.addEdge(3,5);
	al.addEdge(4,3);
	al.addEdge(4,5);
	al.addEdge(4,6);
	al.addEdge(5,3);
	al.addEdge(5,4);
	al.addEdge(5,6);
	al.addEdge(5,7);
	al.addEdge(6,4);
	al.addEdge(6,5);
	al.addEdge(6,7);
	al.addEdge(7,5);
	al.addEdge(7,6);
	al.printGraph();
	BFS bfs = new BFS();
    	bfs.BreadthFS(0,al);
	bfs.printShortestPath(0,7,al);
    }
}
