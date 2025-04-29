You are given a completed 4x4 Sudoku board. Your task is to write a program that determines whether the board is valid.<br/>

A valid 4x4 Sudoku board must meet the following conditions:<br/>

1. Each row must contain all the numbers from 1 to 4 exactly once.
2. Each column must contain all the numbers from 1 to 4 exactly once.
3. Each of the four 2x2 subgrids (top-left, top-right, bottom-left, bottom-right) must contain all the numbers from 1 to 4 exactly once.<br/>

Input
-----
- The program should read 16 integers from the standard input.
- These integers represent the 4x4 Sudoku board in row-major order (i.e., row by row).
- Each integer should be between 1 and 4 (inclusive).

Output
------
- Output `true` if the Sudoku board is valid.
- Output `false` otherwise.



Example-1:
----------
Input:

1 2 3 4<br/>
3 4 1 2<br/>
2 1 4 3<br/>
4 3 2 1<br/>


Output
-------
true


Example-2
---------
Input :

1 2 3 4<br/>
3 4 1 2<br/>
2 1 1 3<br/>
4 3 2 1<br/>


Output
------
false

```java
import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int grid[][] = new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        
        for(int row[]: grid){
            int seen = 0;
            for(int num: row){
                int mask = 1<<num;
                if((seen&mask)!=0){
                    System.out.println(false);
                    return;
                }
                seen = seen | mask;
            }
        }
        
        System.out.println(true);
        
        
    }
}
```
