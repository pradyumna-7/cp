/* 
A professional thief entered into a floor in a building,
The floor has M*N inter connected rooms, the thief can enter into any room 
from any other room. And there are few rooms closed from inside, so the thief 
cannot enter into them. Initially the thief is at room[0][0] and has to exit 
from room[m-1][n-1].

You will be given the array room[][], filled with either 0 or 1.
Here, 1-indiactes a closed room, 0-indiactes a open room.
Your task is to find and print the number of unique escape routes 
from room[0][0] and room[m-1][n-1]. And the thief can move only in 
two directions one is forward direction and other is downward direction.


Input Format:
-------------
Line-1: Two space separated integers, M and N.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
0 0 0 0
0 1 0 0
0 0 1 0

Sample Output-1:
----------------
2


Sample Input-2:
---------------
4 4
0 0 0 0
0 0 1 0
1 0 0 0
0 0 1 0

Sample Output-2:
----------------
3
 */

import java.util.*;
class Solution{
    static int dirs[][] = {{0,1},{1,0}};
    static int count=0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int grid[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                grid[i][j]=sc.nextInt();
            }
        }        
        bfs(grid,0,0,m,n);
        
        System.out.println(count);
    }
    
    static void bfs(int grid[][], int i, int j, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        
        while(!q.isEmpty()){
            int curr[] = q.poll();
            for(int dir[]: dirs){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==0){
                    if(x==m-1 && y==n-1){
                        count++;
                        break;
                    }
                    q.offer(new int[]{x,y});
                    // grid[x][y]=1;
                }
            }
        }
    }
}