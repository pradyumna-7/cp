/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.
You must solve it in O(n) time complexity.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Note: You are supposed to print the K'th largest height in the sorted order of heights[].
 Not the K'th distinct height
 */

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt(); 
        
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Treap treap = new Treap();
        TreapNode root = null;
        for (int i : arr) {
            root = treap.insertNode(root, i);
        }

        Treap.K = k;  
        treap.inorder(root);
    }
}

class TreapNode {
    int key, priority;
    TreapNode left, right;

    public TreapNode(int key) {
        this.key = key;
        this.priority = (int) (Math.random() * 100);
        this.left = this.right = null;
    }
}

class Treap {
    static int K; 

    public TreapNode rotateRight(TreapNode y) {
        TreapNode x = y.left;
        TreapNode t2 = x.right;

        x.right = y;
        y.left = t2;
        return x;
    }

    public TreapNode rotateLeft(TreapNode y) {
        TreapNode x = y.right;
        TreapNode t2 = x.left;

        x.left = y;
        y.right = t2;
        return x;
    }

    public TreapNode insertNode(TreapNode root, int key) {
        if (root == null) return new TreapNode(key);

        if (key <= root.key) {
            root.left = insertNode(root.left, key);
            if (root.left != null && root.left.priority > root.priority) {
                root = rotateRight(root);
            }
        } else {
            root.right = insertNode(root.right, key);
            if (root.right != null && root.right.priority > root.priority) {
                root = rotateLeft(root);
            }
        }
        return root;
    }

    public void inorder(TreapNode root) {
        if (root != null) {
            inorder(root.right);
            K--; 
            if (K == 0) {
                System.out.println(root.key);
                return;
            }
            inorder(root.left);
        }
    }
}
