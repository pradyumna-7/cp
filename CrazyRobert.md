Mr. Crazy Robert is in a Mall, There are N stalls which are interconnected.<br/>
i.e., you can visit a stall-'i',if you visit stall-'i-1' only.<br/>

Mr. Robert can start at stall-0 and visit stall-1, stall-2,...,so on.<br/>

He is given an array of integers amount[], he need to pay amount[i] to visit <br/>
stall-'i'. And also he is given a coupon worth amount C INR. <br/>
Mr. Crazy Robert can use the coupon atmost once, to pay atmost an amount C INR.<br/>

Now, Mr. Crazy Robert task is to visit all the stalls in the mall. He must have <br/>
atleast an amount 1$ with him all the time.<br/>

Your task is to find the minimum amount that Crazy Robert need to visit <br/>
all the stalls in the Mall.


Input Format:
-------------
Line-1: Two space separated integers, N and C.<br/>
Line-2: N comma separated integers, <br/>

Output Format:
--------------
Print an integer, the minimum amount.<br/>

Sample Input-1:
---------------
6 4<br/>
1,5,10,8,6,4<br/>

Sample Output-1:
----------------
31<br/>

Explanation:
------------
One optimal way to visit all the stalls is to start with an amount 31 INR:<br/>
At stall-1, pay 1 INR. He has 31 - 1 = 30 INR left.<br/>
At stall-2, pay 5 INR. He has 30 - 5 = 25 INR left.<br/>
At stall-3, pay 10 INR. He has 25 - 10 = 15 INR left.<br/>
At stall-4, pay 8 INR. He has 15 - 8 = 7 INR left.<br/>
At stall-5, pay 6 INR. He uses coupon worth 4 and pay 4 INR.<br/>
            So, 7 + 4 - 6 = 5 INR left.<br/>
At stall-6, pay 4 INR. He has 5 - 4 = 1 INR left.<br/>
So, the minimum amount is 31 INR he need to start with.<br/>


Sample Input-2:
---------------
6 12<br/>
7,7,9,6,2,6<br/>

Sample Output-2:
----------------
29


Sample Input-2:
---------------
6 0<br/>
7,7,9,6,2,6<br/>

Sample Output-2:
----------------
38


```java
import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coupon = sc.nextInt();
        sc.nextLine();
        String input[] = sc.nextLine().split(",");
        int stalls[] = new int[n];
        
        int total = 0;
        int saving = 0;
        for(int i=0; i<n; i++){
            stalls[i] = Integer.parseInt(input[i]);
            total+=stalls[i];
            saving = Math.max(saving, Math.min(stalls[i],coupon));
        }
        
        System.out.println(total-saving+1);
    }
}
```