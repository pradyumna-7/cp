Umesh is a Mathematician,<br/>
He is given a task to his student Shanker, <br/>
There are N coins in a row, indexed from 0 to N-1, intially all the coins are <br/>
facing "tail". And Umesh has given him a final State-to-Achieve.<br/>

Shanker can achieve the final state by doing a swap operation as follows:<br/>
    - Shanker can choose any index i, 
    - all the coins has to be swap their faces, from "head" to "tail" 
    or "tail to "head" from index 'i' to 'N-1'.<br/>

Shanker is given a binary string S, State-to-Achieve contains [0,1] only. <br/>
"tail" indicates with '0' and "head" indicates with '1'<br/>

Please help Shanker to find the minimum number of swap operations required <br/>
to reach State-to-Achieve.<br/>


Input Format:
-------------
A String S, final State-to-Achieve.<br/>

Output Format:<br/>
--------------CP<br/>
Print an integer, minimum number of swap operations.<br/>


Sample Input-1:
---------------
10111010<br/>

Sample Output-1:
----------------
6<br/>

Explanation: 
------------
Initial configuration "00000000".<br/>
swap from the first coin: "00000000" -> "11111111"<br/>
swap from the second coin: "11111111" -> "10000000"<br/>
swap from the third coin: "10000000" -> "10111111"<br/>
swap from the sixth coin: "10111111" -> "10111000"<br/>
swap from the seventh coin: "10111000" -> "10111011"<br/>
swap from the eighth coin: "10111011" -> "10111010"<br/>
A total of 6 swap operations required.<br/>


Sample Input-2:
---------------
11111<br/>

Sample Output-2:
----------------
1<br/>

```java
import java.util.*;

class Solution {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String bin = sc.next();  
        
       
        int swaps = 0;
        char curr='0';
        
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) != curr) {
                swaps++;  
                curr = (curr == '0') ? '1' : '0';
            }
        }
        
        System.out.println(swaps);
    }
}
```