import java.util.*;

class Solution {
    static int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    
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
                    if (dfs(grid, i, j, n, m, target, 0, new boolean[n][m])) {
                        System.out.println("True");
                        return;
                    }
                }
            }
        }

        System.out.println("False");
    }

    static boolean dfs(char[][] grid, int x, int y, int n, int m, String target, int index, boolean[][] visited) {
        if (index == target.length()) return true;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || grid[x][y] != target.charAt(index)) return false;

        visited[x][y] = true;

        for (int[] dir : dirs) {
            if (dfs(grid, x + dir[0], y + dir[1], n, m, target, index + 1, visited)) return true;
        }

        visited[x][y] = false;
        return false;
    }
}
