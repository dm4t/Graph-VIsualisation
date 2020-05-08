// Java program to print DFS traversal from a given given graph 
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


// This class represents a directed graph using adjacency list 
// representation

class Graph 
{ 
    private int V;   // No. of vertices 
  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
    } 
  
    // A function used by DFS 
    void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    } 
  
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
        System.out.println("_______________Od matcica:DFS______________");
        graf.DFS(10);
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