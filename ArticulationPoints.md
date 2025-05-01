Given an undirected, connected graph, identify all articulation points in the graph.<br/>

An articulation point (or cut vertex) is a vertex that, when removed along with its associated edges, <br/>
increases the number of connected components in the graph. These vertices are critical for maintaining the connectivity of the graph.<br/>

Input Format:
------------
- The first line contains two integers V and E — the number of vertices and edges in the graph.
- The next E lines contain two integers u and v — representing an undirected edge between vertex u and vertex v.
Vertices are numbered from 0 to V - 1.<br/>

Output Format:
--------------
- Print a list of articulation points in increasing order.
- If there are no articulation points, print an empty list [].

Constraints:
-------------
- 1≤ V ≤10^4
- 0≤ E ≤10^5
- No self-loops or multiple edges.

Example Input 1:
----------------
5 5<br/>
1 0<br/>
0 2<br/>
2 1<br/>
0 3<br/>
3 4<br/>

Example Output 1:
------------------
[0, 3]<br/>

Explanation: 
-------------
Removing vertex 0 disconnects 3 and 4 from the rest of the graph.  <br/>
Removing 3 disconnects 4. So both are articulation points.<br/>

Example Input 2:
-----------------
4 3<br/>
0 1<br/>
1 2<br/>
2 3<br/>

Example Output 2:
-----------------
[1, 2]<br/>

Notes:
-------
- The graph may contain multiple components.
- The result should be based on DFS traversal using Tarjan’s algorithm for finding articulation points efficiently.


```java
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < v; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        boolean[] visited = new boolean[v];
        int[] disc = new int[v];
        int[] low = new int[v];
        Set<Integer> artiPoints = new TreeSet<>();  
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, visited, disc, low, -1, graph, artiPoints);
            }
        }
        System.out.println(artiPoints);
    }
    
    static int time = 0;
    static void dfs(int u, boolean[] visited, int[] disc, int[] low, int parent, Map<Integer, ArrayList<Integer>> graph, Set<Integer> artiPoints) {
        visited[u] = true;
        time++;
        disc[u] = low[u] = time;
        int children = 0;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                children++;
                dfs(v, visited, disc, low, u, graph, artiPoints);
                
                low[u] = Math.min(low[u], low[v]);
                if (parent != -1 && low[v] >= disc[u]) {
                    artiPoints.add(u);
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (parent == -1 && children > 1) {
            artiPoints.add(u);
        }
    }
}
```