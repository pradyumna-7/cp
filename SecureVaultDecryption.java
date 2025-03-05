/*
Agent X is on a top-secret mission to access a secure vault that contains classified information.
To unlock the vault, Agent X has received an encrypted numeric sequence from an anonymous source. However, the sequence follows a unique encryption pattern based on a circular array and a key value (k).

To decrypt the sequence, follow these rules:

If k > 0, replace each number with the sum of the next k numbers in the sequence.
If k < 0, replace each number with the sum of the previous |k| numbers.
If k == 0, replace each number with 0.

Since the sequence is circular, the next element of the last number is the first number
and the previous element of the first number is the last number.
Can you help Agent X decrypt the vault code?

Input Format:
-------------
An integer n representing the length of the numeric sequence.
A list of n integers representing the encrypted sequence.
An integer k representing the key.

Output Format:
--------------
A list of n integers representing the decrypted sequence.

Example 1:
Input:
------
5  
3 6 1 8 4  
2  
Output:
-------
[7, 9, 12, 12, 9] 

Explanation:
Each number is replaced by the sum of the next 2 numbers:

3 → (6 + 1) = 7
6 → (1 + 8) = 9
1 → (8 + 4) = 12
8 → (4 + 3) = 12 (wraps around)
4 → (3 + 6) = 9 (wraps around)

Example 2:
Input:
4  
2 5 7 1  
-2  
Output:
[8, 9, 6, 12]

Explanation:
------------
Each number is replaced by the sum of the previous 2 numbers:

2 → (1 + 7) = 8
5 → (2 + 1) = 9
7 → (5 + 2) = 6
1 → (7 + 5) = 12

Constraints:
------------
1 ≤ n ≤ 100
1 ≤ sequence[i] ≤ 100
-(n - 1) ≤ k ≤ n - 1

Challenge:
----------
Can you optimize your solution to run efficiently for large values of n? 
 */

import java.util.*;
public class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)arr[i] = sc.nextInt();
        int k = sc.nextInt();
        
    //     FenwickTree fenwickTree = new FenwickTree(n);
    //     for (int i = 0; i < n; i++){
    //         fenwickTree.update(i, arr[i]);
    //     }
        int[] decrypted = new int[n];
    //     for (int i = 0; i < n; i++){
    //         if (k > 0){
    //             int right = (i + k) % n;
    //             decrypted[i] = (i + k >= n)
    //                     ? fenwickTree.rangeSum(i + 1, n - 1) + fenwickTree.rangeSum(0, right)
    //                     : fenwickTree.rangeSum(i + 1, right);
    //         } 
    //         else {
    //             int left = (i + k + n) % n;
    //             decrypted[i] = (i + k < 0)
    //                     ? fenwickTree.rangeSum(0, i - 1) + fenwickTree.rangeSum(left, n - 1)
    //                     : fenwickTree.rangeSum(left, i - 1);
    //         }
    //     }
        
    //     System.out.println(Arrays.toString(decrypted));
        
    // }
    

        if (k > 0){
            for (int i = 0; i < n; i++){
                for (int j = 1; j <= k; j++){
                    decrypted[i] += arr[(i + j) % n];
                }
            }
        } else if (k < 0){
            for (int i = 0; i < n; i++){
                for (int j = 1; j <= Math.abs(k); j++){
                    decrypted[i] += arr[(i - j + n) % n]; 
                }
            }
        }
        System.out.println(Arrays.toString(decrypted));
    
    }
}

// class FenwickTree{
//     int[] BIT;
//     int n;
//     FenwickTree(int size){
//         this.n = size;
//         this.BIT = new int[n + 1];
//     }

//     public void update(int index, int value){
//         index++; 
//         while (index <= n){
//             BIT[index] += value;
//             index += index & -index;
//         }
//     }

//     public int prefixSum(int index) {
//         index++; 
//         int sum = 0;
//         while (index > 0){
//             sum += BIT[index];
//             index -= index & -index;
//         }
//         return sum;
//     }
//     public int rangeSum(int left, int right){
//         if (left > right) return 0; 
//         return prefixSum(right) - prefixSum(left - 1);
//     }

// }