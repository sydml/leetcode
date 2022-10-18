package leetcode.editor.cn;

import java.util.List;

/**
 * author: liuyuming
 * date: 2022-10-02 22:37:32
 */
//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// Related Topics 数组 回溯 👍 161 👎 0

public class EightQueensLcci{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public List<List<String>> solveNQueens(int n) {

    }


    int[] result = new int[8];//全局或成员变量,下标表示行,值表示queen存储在哪一列
    public List<List<String>> solveNQueens(int n) { // 调用方式：cal8queens(0);
        if (row == 8) { // 8个棋子都放置好了，打印结果
            printQueens(result);
            return; // 8行棋子都放好了，已经没法再往下递归了，所以就return
        }
        for (int column = 0; column < 8; ++column) { // 每一行都有8中放法
            if (isOk(row, column)) { // 有些放法不满足要求
                result[row] = column; // 第row行的棋子放到了column列
                cal8queens(row+1); // 考察下一行
            }
        }
    }

    private boolean isOk(int row, int column) {//判断row行column列放置是否合适
        int leftup = column - 1, rightup = column + 1;
        for (int i = row-1; i >= 0; --i) { // 逐行往上考察每一行
            if (result[i] == column) return false; // 第i行的column列有棋子吗？
            if (leftup >= 0) { // 考察左上对角线：第i行leftup列有棋子吗？
                if (result[i] == leftup) return false;
            }
            if (rightup < 8) { // 考察右上对角线：第i行rightup列有棋子吗？
                if (result[i] == rightup) return false;
            }
            --leftup; ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
	    Solution solution = new EightQueensLcci().new Solution();
	}
}
