// Java program to print BFS traversal from a given source vertex. 
// BFS(int s) traverses vertices reachable from s. 
import java.io.*; 
import java.util.*; 
  
// This class represents a directed graph using adjacency list 
// representation 
class Graph 
{ 
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists 
  
    // Constructor 
    Graph(int v) 
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
        Graph g = new Graph(4); 
  
        int[][] matrica = readFile("matrix.txt");
        int sizeOfMatrix = matrica.length;   
        Graph graf = new Graph(sizeOfMatrix);
        
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