Arjun wants to build some homes in a land of size R*C.<br/>
He wanted to construct homes in rectangular shape.<br/>
The place which is remained will be used for gradening.<br/>
Accordingly he has prepared the plan and given as<br/>
an 2d array plan[][], where 1 indicates home, and 0 indicates garden area.<br/>

A home is set of cells with value 1 in rectangular shape.<br/>
He wants to findout all the homes in the plan and store their co-ordinates in <br/>
the following order, coords[i] = [x1,y1,x2,y2], where (x1,y1) is the starting<br/>
co-ordinate (top left corner), and (x2,y2) is the ending co-ordinate <br/>
(bottom right corner) of i-th home.<br/>

Your task is to help Arjun to find all the homes and return the coords[][] of <br/>
all the homes from top left corner to bottom right corner.<br/>
<br/>
NOTE: No two homes are adjacent to each other in 4 directions,<br/>
(left, right, top, bottom).<br/>
<br/>
Input Format:
-------------
Line-1: Two integers R and C, size of the land.<br/>
Next R lines: C space separated integers, either 0 or 1<br/>
0- represents garden area land and 1- represents the home.<br/>

Output Format:
--------------
Print 2d array, the co-ordinates of all homes.<br/>


Sample Input-1:
---------------
2 3<br/>
1 0 0<br/>
0 1 1<br/>
 
Sample Output-1:
----------------
[0, 0, 0, 0][1, 1, 1, 2]<br/>


Sample Input-2:
---------------
4 4<br/>
1 1 0 1<br/>
0 0 0 0<br/>
1 1 0 1<br/>
1 1 0 1<br/>
 
Sample Output-2:
----------------
[0, 0, 0, 1][0, 3, 0, 3][2, 0, 3, 1][2, 3, 3, 3]<br/>

### Code:

```java
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] land = new int[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                land[i][j] = sc.nextInt();
            }
        }

        List<int[]> coords = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (land[i][j] == 1) {
                    int x1 = i, y1 = j;
                    int y2 = y1;
                    while (y2 + 1 < c && land[x1][y2 + 1] == 1) {
                        y2++;
                    }
                    int x2 = x1;
                    while (x2 + 1 < r) {
                        boolean rowHasOnes = true;
                        for (int col = y1; col <= y2; col++) {
                            if (land[x2 + 1][col] != 1) {
                                rowHasOnes = false;
                                break;
                            }
                        }
                        if (rowHasOnes) {
                            x2++;
                        } else {
                            break;
                        }
                    }
                    for (int x = x1; x <= x2; x++) {
                        for (int y = y1; y <= y2; y++) {
                            land[x][y] = -1;
                        }
                    }
                    coords.add(new int[]{x1, y1, x2, y2});
                }
            }
        }
        for (int[] coord : coords) {
            System.out.print("[" + coord[0] + ", " + coord[1] + ", " + coord[2] + ", " + coord[3] + "]");
        }
    }
}
```
