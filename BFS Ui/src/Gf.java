// Java program to print BFS traversal from a given source vertex. 
// BFS(int s) traverses vertices reachable from s. 
import java.awt.Color;
import java.io.*; 
import java.util.*;
import org.graphstream.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;


  
// This class represents a directed graph using adjacency list 
// representation 
class Gf 
{ 
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists 
  
    // Constructor 
    Gf(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    // Function to add an edge into the graph 
    void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
    } 
  
    // prints BFS traversal from a given source s 
    void BFS(int s) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[V]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 
  
    // Driver method to 
    public static void main(String args[]) 
    { 
        Gf g = new Gf(4); 
        Graph graph = new SingleGraph("graf");
        graph.setStrict(false);
        graph.setAutoCreate( true );
  
        int[][] matrica = readFile("matrix.txt");
        int sizeOfMatrix = matrica.length;   
        Gf graf = new Gf(sizeOfMatrix);
        
        for(int i=0;i<sizeOfMatrix;i++)
        {
        	for(int j=0;j<sizeOfMatrix;j++)
        	{
        		if(matrica[i][j]==1)
        		{
        			graf.addEdge(i, j);
        		}
        	}
        }
      
        System.out.println();
        System.out.println("_______________Od matcica:BFS______________");
        graf.BFS(10);
        
        int n = sizeOfMatrix;
		for(int s = 0;s<n;s++) //Dodavanje na teminja 
		{
			String m = String.valueOf(s);
			graph.addNode(m);
		}
		for(int i1=0;i1<n;i1++){	//vizualizacij na graf od veke kriiranata matrica
			for(int j1=0;j1<n;j1++)
			{
				if(matrica[i1][j1]==1)
				{
					String i,j;
					i = String.valueOf(i1);
					j = String.valueOf(j1);
					graph.addEdge(i+j, i, j,true);			
									
				}
			}			
		}
		
		graph.addAttribute("ui.stylesheet", "graph { fill-color: gray; }");
        
		for (Node node : graph) {
			node.addAttribute("ui.style", "shape:circle;fill-color: red;size: 10px;");
			node.addAttribute("ui.label", node.getId());
	        
	        
	    }		

		graph.display();
    } 
   
    
    public static int[][] readFile(String file){
		int[][] mat = null;
		try
		{
			File f = new File(file);
			Scanner s = new Scanner(f);
			double size = 0;
			while(s.hasNextInt())
			{
				size++;
				s.nextInt();
			}
			int big = (int)Math.sqrt(size);	
			mat = new int[big][big];
			
			Scanner s1 = new Scanner(f);
			for(int i = 0;i<big;i++)
			{
				for(int j = 0;j<big;j++){
					mat[i][j] = s1.nextInt();
					System.out.print(mat[i][j]+" ");
				}
				System.out.println();
			}
		}
		catch(Exception e){
			System.out.print(e);
			return null;
		}	
		return mat;
	}
    
    
} 
// This code is contributed by Aakash Hasija 