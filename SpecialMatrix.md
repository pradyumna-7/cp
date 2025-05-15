Venkatadri is a maths teacher.<br/>
He is teaching matrices to his students.<br/>
He is given a matrix of size m*n, and it contains only positive numbers.<br/>
He has given a task to his students to find the special matrix, <br/>
in the iven matrix A[m][n].<br/>
A special matrix has following property:<br/>
	- The sum of elements in each row, each column and the two diagonals are equal.
	- Every 1*1 matrix is called as a special matrix.
	- The size of the special matrix should be a square, i.e., P*P.

Your task is to help the students to find the speical matrix  with max size P.<br/>


Input Format:
-------------
Line-1: Two space separated integers M and N, size of the matrix.<br/>
Next M lines: N space separated integers m and n.<br/>

Output Format:
--------------
Print an integer, maximum size P of the special matrix.<br/>


Sample Input-1:
---------------
5 5<br/>
7 8 3 5 6<br/>
3 5 1 6 7<br/>
3 5 4 3 1<br/>
6 2 7 3 2<br/>
5 4 7 6 2<br/>

Sample Output-1:
----------------
3<br/>

Explanation:
------------
The special square is:<br/>
5 1 6<br/>
5 4 3<br/>
2 7 3<br/>


Sample Input-2:
---------------
4 4<br/>
7 8 3 5<br/>
3 2 1 6<br/>
3 2 3 3<br/>
6 2 3 3<br/>

Sample Output-2:
----------------
2<br/>

Explanation:
------------
The special square is:<br/>
3 3<br/>
3 3<br/>

```java
import java.util.*;

class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int matrix[][] = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int p = Math.min(m,n)-1;
        for(; p >= 1; p--) {
            for(int i = 0; i <= m - p; i++) {
                for(int j = 0; j <= n - p; j++) {
                    int[][] square = new int[p][p];
                    for (int r = 0; r < p; r++) {
                        square[r] = Arrays.copyOfRange(matrix[i + r], j, j + p);
                    }
                    if (check(square)) {
                        System.out.println(p);
                        return;
                    }
                }
            }
        }
        System.out.println(1);
    }
    
    public static boolean check(int[][] square) {
        int n = square.length;
        int targetSum = 0;
        
        for(int num : square[0]) targetSum += num;
        
        for(int i = 1; i < n; i++) {
            int rowSum = 0;
            for(int j = 0; j < n; j++) rowSum += square[i][j];
            if(rowSum != targetSum) return false;
        }
        
        for(int j = 0; j < n; j++) {
            int colSum = 0;
            for(int i = 0; i < n; i++) colSum += square[i][j];
            if(colSum != targetSum) return false;
        }
        
        int mainDiag = 0;
        for(int i = 0; i < n; i++) mainDiag += square[i][i];
        if(mainDiag != targetSum) return false;
        
        int antiDiag = 0;
        for(int i = 0; i < n; i++) antiDiag += square[i][n - 1 - i];
        if(antiDiag != targetSum) return false;
    
        return true;
    }

}
```
