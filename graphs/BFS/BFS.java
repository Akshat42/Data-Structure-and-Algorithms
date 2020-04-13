import java.util.*;

class AdjacencyList {
    int V;
    ArrayList<ArrayList<Integer>> al;

    public AdjacencyList(int V) {
	    this.V = V;
	    al =  new ArrayList<>(V);
	    for(int i=0;i<V;i++) {
		al.add(new ArrayList<Integer>());
	    }
    }

    public void addEdge(int u, int v) {
	al.get(u).add(v);
    }

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
    public void BreadthFS(int s,AdjacencyList AL) {
	int visited[] = new int[AL.V];
//	System.out.println("length of visited "+visited.length);
	Queue<Integer> q = new LinkedList<>();
	q.add(s);
	visited[s] = 1;
	while(q.size() != 0) {
	    int v = q.poll();
//	    System.out.println("polled vertex "+v);
	//    visited[v] = 1;
	    System.out.print(v+ " ");
	    for(int i=0;i<AL.al.get(v).size();i++) {
		if(visited[AL.al.get(v).get(i)] == 0){
		    q.add(AL.al.get(v).get(i));
		    visited[AL.al.get(v).get(i)] = 1;
		}
	    } 
//	    System.out.println(q);
	}
    }
    public static void main (String args[]) {
	AdjacencyList al = new AdjacencyList(4);
	al.addEdge(0,1);
	al.addEdge(0,2);
	al.addEdge(1,2);
	al.addEdge(2,0);
	al.addEdge(2,3);
	al.addEdge(3,3);
//	al.addEdge(2,4);
//	al.addEdge(3,4);
//	al.addEdge(3,5);
//	al.addEdge(4,1);
//	al.addEdge(4,2);
//	al.addEdge(4,5);
//	al.addEdge(5,3);
//	al.addEdge(5,4);
	al.printGraph();
	BFS bfs = new BFS();
	bfs.BreadthFS(2,al);
    }
}
