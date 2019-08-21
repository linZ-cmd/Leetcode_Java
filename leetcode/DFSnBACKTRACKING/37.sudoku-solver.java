/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (38.15%)
 * Likes:    1003
 * Dislikes: 67
 * Total Accepted:    139.8K
 * Total Submissions: 365.8K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 * 
 * Note:
 * 
 * 
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique
 * solution.
 * The given board size is always 9x9.
 * 
 * 
 */
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    int k = j/3 + (i/3)*3;
                    blocks[k][num] = true;
                }
            }
        }
        dfs(board, rows, cols, blocks, 0);
    }

    public boolean dfs(char[][] board, boolean[][] rows, boolean[][] cols,boolean[][] blocks, int index) {
        if (index == 81) return true;
        int row = index/9;
        int col = index%9;
        int block = col/3 + (row/3)*3;
        if (board[row][col] != '.') {
            return dfs(board, rows, cols, blocks, index+1);
        } else {
            for (char i='1'; i<='9'; i++) {
                int num = i-'1';
                if (!rows[row][num] && !cols[col][num] && !blocks[block][num]) {
                    rows[row][num] = true;
                    cols[col][num] = true;
                    blocks[block][num] = true;
                    board[row][col] = i;
                    if (dfs (board, rows, cols, blocks, index+1)) return true;
                    rows[row][num] = false;
                    cols[col][num] = false;
                    blocks[block][num] = false;
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
}

