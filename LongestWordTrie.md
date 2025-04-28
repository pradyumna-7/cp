In a school, the students are given an array of strings words[]. Students have 
to find the longest string in words[] such that every prefix of it is also in words.</br>

For example, let words = ["a", "app", "ap","appl", "apply"]. The string "apply" </br>
has prefixes "ap","app","appl" and "a", all of which are in words.</br>

Your task is the find and return the longest string in words as described above.</br>

If there is more than one string with the same length, return the lexicographically
smallest one, and if no string exists, return "".</br>

Input Format
-------------
Line1: string separated by spaces
 
Output Format
--------------
string 

Sample Input-1:
---------------
k kmi km kmit

Sample Output-1:
----------------
kmit

Explanation:
------------
"kmit" has prefixes "kmi", "km", "k" and all of them appear in words.


Sample Input-2:
---------------
t tup tupl tu tuple tupla

Sample Output-2:
----------------
tupla

Explanation:
------------
Both "tuple" and "tupla" have all their prefixes in words.</br>
However, "tupla" is lexicographically smaller, so we return that.</br>


Sample Input-3:
---------------
abc bc ab abcd

Sample Output-3:
----------------
""

```java
import java.util.*;

class trieHelper 
{
    Trie root = new Trie();
    String res = "";
    public String longestWord(String[] words) 
    {
        for (String word : words) 
			addWord(word);
        for (String word : words) 
			searchPrefix(word);
        return res;
    }
    
    private void searchPrefix(String word) 
    {
        Trie temp = root;  
		for(int i=0; i<word.length(); i++){
		    char ch = word.charAt(i);
		    if (temp.children[ch - 'a'] == null || !temp.children[ch - 'a'].isWord) return;
		  //  sb.append((char)(i+'a'));
		    temp = temp.children[ch-'a'];
		}
		if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0))
            res = word;
	}
    
    private void addWord(String word){
        Trie temp = root;
        for(char ch: word.toCharArray()){
            if(!temp.contains(ch)){
                temp.children[ch-'a'] = new Trie();
                temp.count++;
            }
            temp = temp.children[ch-'a'];
        }
        temp.isWord = true;
    }
}
class Trie 
{
    Trie[] children = new Trie[26];
    boolean isWord;
    int count;
    
    public boolean contains(char ch){
        return children[ch-'a']!=null;
    }
}

class LongestWord
{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String arr[]=sc.nextLine().split(" ");
		System.out.println(new trieHelper().longestWord(arr));
	}
}
```