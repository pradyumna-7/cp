In the bustling city of Lexicon, a renowned detective, Alex, was known for his uncanny ability to decipher hidden messages within seemingly ordinary texts. 
One day, he received a cryptic note containing two strings: a long, seemingly random sequence of letters (the "source string") and a shorter,
enigmatic word (the "pattern string").

The note hinted at hidden clues scattered throughout the source string, each clue being an anagram of the pattern string. 
Alex knew that to crack the case, he had to identify the starting positions of these anagrams within the source string.

Your Task:

You are Alex's trusted assistant, tasked with developing a program to automate this process.

1.  Write a function that takes two strings, s (the source string) and p (the pattern string), as input.
2.  Implement an algorithm to find all starting indices in s where an anagram of p exists.
3.  Return an array (or list) containing these starting indices in any order.

Constraints:

* The input strings s and p will consist of lowercase English letters.
* The length of s will be greater than or equal to the length of p.

Example 1:

Input:
s = "cbaebabacd"
p = "abc"

Output:
[0, 6]

Explanation:
The substrings "cba" (starting at index 0) and "bac" (starting at index 6) are anagrams of "abc".

Example 2:

Input:
s = "abab"
p = "ab"

Output:
[0, 1, 2]

Explanation:
The substrings "ab" (starting at index 0), "ba" (starting at index 1), and "ab" (starting at index 2) are all anagrams of "ab".


```java
import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        
        List<Integer> output = new ArrayList<>();
        
        int n = s.length();
        int m = p.length();
        
        for(int i=0; i<=n-m; i++){
            boolean found = true;
            

            int[] count1 = new int[26];
            int[] count2 = new int[26];
            
            for(int j=i; j<i+m; j++){
                char c = s.charAt(j);
                count1[c-'a']++;
            }
            
            for(char c : p.toCharArray()){
                count2[c-'a']++;
            }
            

            boolean equals = true;
            for(int k=0; k<26; k++){
                if(count1[k] != count2[k]){
                    equals = false;
                    break;
                }
            }
            
            found &= equals;
            
            if(found){
                output.add(i);
            }
        }
        
        System.out.println(output);
    }
}
```