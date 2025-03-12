/*
Given a positive integer n, you can apply one of the following operations:

If n is even, replace n with n / 2.
If n is odd, replace n with either n + 1 or n-1 .
Return the minimum number of operations needed for n to become 1.

Example 1:
Input:8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1

Example 2:
Input:7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1
*/

import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findMin(n));
    }
    
    static int findMin(int n){
        if(n==1) return 0;
        if(n%2==0) return 1 + findMin(n/2);
        else return 1 + Math.min(findMin(n-1),findMin(n+1));
    }
}