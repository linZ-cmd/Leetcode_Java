import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 *
 * https://leetcode.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (18.41%)
 * Likes:    1091
 * Dislikes: 197
 * Total Accepted:    130.6K
 * Total Submissions: 706.9K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such
 * that:
 * 
 * 
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
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
 * Output: []
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
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList();
        Set<String> visited = new HashSet();
        Set<String> toVisit = new HashSet();
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        bfs(beginWord, endWord, graph, wordSet, q, visited, toVisit);
        dfs(beginWord, endWord, graph, res, new ArrayList<>());
        return res;
    }

    public void bfs(String begin, String end, HashMap<String, ArrayList<String>> graph, Set<String> words, Queue<String> q,
    Set<String> visited, Set<String> toVisit) {
        q.add(begin);
        visited.add(begin);
        boolean found = false;
        while (!q.isEmpty()) {
            visited.addAll(toVisit);
            toVisit.clear();
            int size = q.size();
            for (int i=0; i<size; i++) {
                String word = q.poll();
                List<String> wordNeighbor = getNeighbor(word, words);
                for(String neighbor : wordNeighbor) {
                    if (neighbor.equals(end)) found = true;
                    if (!visited.contains(neighbor)) {
                        graph.putIfAbsent(word, new ArrayList<>());
                        graph.get(word).add(neighbor);
                        if (!toVisit.contains(neighbor)) {
                            q.add(neighbor);
                            toVisit.add(neighbor);
                        }
                    }
                }
            }
            if (found) break;
        }
    }

    public void dfs(String begin, String end, HashMap<String, ArrayList<String>> graph, List<List<String>> res,
    ArrayList<String> path) {
        path.add(begin);
        
        if (begin.equals(end)) res.add(new ArrayList<>(path));
        ArrayList<String> neighbors = graph.get(begin);
        if (neighbors != null) {
            for (String neighhor : neighbors) {
                dfs(neighhor, end, graph, res, path);
            }
        }
        path.remove(path.size()-1);
    }

    public List<String> getNeighbor(String word, Set<String> words) {
        List<String> res = new ArrayList<>();
        for (int i=0; i<word.length(); i++) {
            char[] charWord = word.toCharArray();
            for (char cha='a';cha<='z';cha++) {
                charWord[i] = cha;
                String newWord = new String(charWord);
                if (words.contains(newWord)) {
                    res.add(newWord);
                }
            }
        }
        return res;
    }
}
