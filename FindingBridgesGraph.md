In an undirected graph, a bridge (also known as a cut-edge) is an edge that, when removed, increases the number of connected components in the graph. <br/>
In other words, removing a bridge disconnects part of the graph.<br/>

You are given an undirected graph with V vertices and E edges.<br/>
Your task is to identify and print all the bridges in the graph using Depth-First Search (DFS).<br/>

Input Format:
------------
- The first line contains two integers V and E — the number of vertices and edges.
- The next E lines each contain two integers u and v, denoting an undirected edge between vertex u and vertex v.

Output Format:
--------------
- Print the edges that are bridges in the graph.
- Each bridge should be printed as a pair of vertices: u v.
- If there are no bridges, the output should be empty.
- Order of output does not matter.

Constraints:
-------------
- 1≤ V ≤10000 
- 0≤ E ≤100000 
- 0≤ u,v <V
- The graph may be disconnected.
- No multiple edges or self-loops.

Example Input 1:
----------------
5 5<br/>
1 0<br/>
0 2<br/>
2 1<br/>
0 3<br/>
3 4<br/>

Example Output 1:
----------------
3 4<br/>
0 3<br/>

Explanation:
-------------
Removing edge 3 4 disconnects node 4. Similarly, removing edge 0 3 disconnects node 3. These are bridges.<br/>
However, edges like 1 0, 0 2, and 2 1 are not bridges because there are alternative paths to maintain connectivity.<br/>

Note:
-----
- The program uses Tarjan’s Algorithm for bridge detection, which uses discovery times and low values during DFS traversal.
- The edge list in the output does not need to be sorted.

```java
import java.util.*;

public class Solution {
    static int time = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[vertices];
        int[] disc = new int[vertices];
        int[] low = new int[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]){
                dfs(graph, i, visited, disc, low, parent);
            }
        }
    }

    static void dfs(List<List<Integer>> graph, int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                dfs(graph, v, visited, disc, low, parent);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    System.out.println( u + " " + v);
                }
            } 
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
```
