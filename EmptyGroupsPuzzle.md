Pranav has a puzzle board filled with square boxes in the form of a grid.<br/>
Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. <br/>

Pranav wants to find out the number of empty spaces which are completely <br/>
surrounded by the square boxes (left, right, top, bottom) in the board.<br/>

You are given the board in the form of a grid M*N, filled wth 0's and 1's.<br/>
Your task is to help Pranav to find the number of empty groups surrounded by<br/>
the boxes in the puzzle board.<br/>

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in Layout.<br/>
Next M lines: contains N space-separated either 0 or 1.<br/>

Output Format:
--------------
Print an integer, the number of fully trapped air pockets in the layout.<br/>

Sample Input-1:
---------------
6 7<br/>
1 1 1 1 0 0 1<br/>
1 0 0 0 1 1 0<br/>
1 0 0 0 1 1 0<br/>
0 1 1 1 0 1 0<br/>
1 1 1 0 0 1 1<br/>
1 1 1 1 1 1 1<br/>

Sample Output-1:
----------------
2<br/>

Explanation:
------------
The 2 empty groups are as follows:<br/>
1st group starts at cell(1,1), 2nd group starts at cell(3,4).<br/>
The groups which are starts at cell(0,4), cell(1,6) and cell(3,0)<br/>
are not valid empty groups, because they are not completely surrounded by boxes.<br/>


Sample Input-2:
---------------
6 6<br/>
1 1 0 0 1 1<br/>
1 0 1 1 0 1<br/>
0 1 0 1 0 0<br/>
1 1 0 0 0 1<br/>
0 0 1 0 1 1<br/>
1 1 0 1 0 0<br/>

Sample Output-2:
----------------
1<br/>

Explanation:
------------
The only empty group starts at cell(1,1) is surrounded by boxes.<br/>

### Code:
```java
import java.util.*;
public class Solution {
    static int[][] grid;
    static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean[][] visited;
    static int m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        grid = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) dfs(i, 0);
            if (grid[i][n-1] == 0) dfs(i, n-1);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0) dfs(0, j);
            if (grid[m-1][j] == 0) dfs(m-1, j);
        }
        
        int count = 0;
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 0 || visited[x][y]) return;
        visited[x][y] = true;
        for (int[] d : dirs)
            dfs(x + d[0], y + d[1]);
    }
}

```