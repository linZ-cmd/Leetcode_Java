import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (24.98%)
 * Likes:    1666
 * Dislikes: 868
 * Total Accepted:    285.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        Set<String> wordSet = new HashSet();
        for (String word:wordList) wordSet.add(word);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!visited.contains(endWord)) {
            Set<String> curVisited = new HashSet();
            for (String word:visited) {
                for (int i=0; i<word.length(); i++) {
                    char[] charWord = word.toCharArray();
                    for (char ch='a'; ch<='z'; ch++) {
                        charWord[i] = ch;
                        String curWord = new String(charWord);
                        if (wordSet.contains(curWord)) {
                            curVisited.add(curWord);
                            wordSet.remove(curWord);                            
                        }
                    }
                }
            }
            if (curVisited.size() == 0) return 0;
            res++;
            visited = curVisited;
        }
        res ++;
        return res;
    }
}

