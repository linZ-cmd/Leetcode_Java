/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (31.99%)
 * Likes:    2039
 * Dislikes: 104
 * Total Accepted:    313K
 * Total Submissions: 976.6K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int row = board.length;
        int col = board[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if(dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int index) {
        int row = board.length;
        int col = board[0].length;    
        int leng = word.length();
        if (index==leng) return true;
        if (x<0||x>=row||y<0||y>=col) return false;
        if (word.charAt(index) != board[x][y])return false;
        board[x][y] = '.';
        boolean res = dfs(board,x-1,y,word,index+1) ||
        dfs(board,x+1,y,word,index+1) ||
        dfs(board,x,y-1,word,index+1) ||
        dfs(board,x,y+1,word,index+1);
        board[x][y] = word.charAt(index);
        return res;
    }
}

