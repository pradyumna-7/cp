Barnaby loved finding hidden words in his big storybook. He had a special list of his favorite words.
For each favorite word he found in the story, he would write down where it began and where it ended.
Can you help Barnaby find all his favorite words and their starting and ending spots in the storybook?

Example 1:
----------
input= 
thestoryofleetcodeandme
story fleet leetcode

Output=
3 7
9 13 
10 17

Example 2:
----------
input= 
ababa
aba ab
output=
0 1 
0 2 
2 3
2 4

Explanation: 
Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].

Note: Input formate is string and followed by substring ,
      Output print starting and ending index pairs.

```java
import java.util.*;
class Solution{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String input[] = sc.nextLine().split(" ");
        
        Trie trie = new Trie();
        for(String word: input){
            trie.insert(word);
        }
        
        trie.find(s);
        
    }
    
    static class Node{
        Node chars[] = new Node[26];
        boolean isEnd = false;
        
        public boolean contains(char ch){
            return chars[ch-'a']!=null;
        }
    }
    
    static class Trie{
        Node root;
        Trie(){
            root = new Node();
        }
        
        public void insert(String key){
            Node temp = root;
            for(char ch: key.toCharArray()){
                if(!temp.contains(ch)){
                    temp.chars[ch-'a'] = new Node();
                }
                temp = temp.chars[ch-'a'];
            }
            temp.isEnd=true;
        }
        
        public void find(String s) {
            for(int i=0; i<s.length(); i++){
                Node temp = root;
                int j = i;
                while(j < s.length() && temp.contains(s.charAt(j))){
                    temp = temp.chars[s.charAt(j)-'a'];
                    if(temp.isEnd){
                        System.out.println(i+" "+j);
                    }
                    j++;
                }
            }
        }
    }
}
```