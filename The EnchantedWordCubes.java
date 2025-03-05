/*
In the kingdom of Lexiconia, a wizard found magical cubes, each with a letter inscribed on it.
Using these cubes, he could form non-empty words of lengths ranging from 1 to the total number of cubes.

Each arrangement of letters created a distinct word, where order mattered. Given a string S representing the letters on the cubes
the wizard's challenge was to determine the total number of unique words he could form.

Can you help him find the answer?

Input Format:
-------------
A string S, consist of A-Z letters only.

Output Format:
--------------
Print an integer, number of possible non-empty distinct words.


Sample Input-1:
---------------
EGG

Sample Output-1:
----------------
8

Explanation:
--------------
The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


Sample Input-2:
---------------
MADAM

Sample Output-2:
----------------
89 
 */

import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Set<String> distinct = new HashSet<>();
        boolean visited[] = new boolean[input.length()];
        dfs(input,visited,new StringBuilder(),distinct);
        System.out.println(distinct.size());
    }
    
    static void dfs(String input, boolean[] visited, StringBuilder curr, Set<String> distinct){
        if(curr.length()>0)distinct.add(curr.toString());
        
        for(int i=0; i<input.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                curr.append(input.charAt(i));
                dfs(input, visited, curr, distinct);
                curr.deleteCharAt(curr.length()-1);
                visited[i]=false;
            }
        }
    }
}