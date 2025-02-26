import java.util.*;

class Solution {
    static int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};  
    // static boolean flag = false;  
     
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char grid[][] = new char[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) grid[i][j] = sc.next().charAt(0);
        }
        
        String target = sc.next();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == target.charAt(0)) {
                    if (bfs(grid, i, j, n, m, target)) {
                        System.out.println("true");
                        return;
                    }
                }
            }
        }
        
        System.out.println("false");  
    }
    
    static boolean bfs(char[][] grid, int i, int j, int n, int m, String target) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j, 1});
        boolean[][] visited = new boolean[n][m];  
        visited[i][j] = true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1], count = curr[2];

            if (count == target.length()) return true;  // Found full word

            for(int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m && 
                   !visited[newX][newY] && grid[newX][newY] == target.charAt(count)) {
                    visited[newX][newY] = true;
                    q.offer(new int[]{newX, newY, count + 1});
                }
            }
        }
        
        return false;
    }
}
