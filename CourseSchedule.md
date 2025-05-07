```java
import java.util.*;
public class Test{
    public static List<Integer> findCourseOrder(int n, int[][] prerequisites){
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites){
            int course = pair[0];
            int pre = pair[1];
            adjList.get(pre).add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (inDegree[i] == 0)
                queue.offer(i);
            }
        while (!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            for (int neighbor : adjList.get(current)){
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.offer(neighbor);
                }
        }
        if (result.size() != n)
            return Arrays.asList(-1);
            return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] prerequisites = new int[m][2];
        for (int i = 0; i < m; i++){
            prerequisites[i][0] = sc.nextInt(); 
            prerequisites[i][1] = sc.nextInt(); 
        }
        List<Integer> order = findCourseOrder(n, prerequisites);
        for (int course : order){
            System.out.print(course + " ");
        }
    }
}
```