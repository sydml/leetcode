package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * author: liuyuming
 * date: 2022-10-17 15:54:25
 */
//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1534 👎 0

public class NQueens{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //创建结果集res
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        ArrayList<StringBuilder> track = new ArrayList<>();
        //初始化棋盘
        for(int i = 0; i < n; i++){
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < n; j++){
                str.append('.');
            }
            track.add(str);
        }
        backtrace(track, 0);
        return res;
    }

    void backtrace(ArrayList<StringBuilder> track, int row){
        // 如果每一行都成功放置了皇后，记录结果
        if(row == track.size()){
            ArrayList<String> track1 = new ArrayList<>();
            //讲StringBuilder类转化为String类
            for(int i = 0; i < track.size(); i++){
                track1.add(track.get(i).toString());
            }
            res.add(track1);
            return;
        }

        int n = track.get(row).length();
        for(int col = 0; col < n; col++){
            if(!isValid(track,row,col)) continue;
            //做选择
            track.get(row).setCharAt(col,'Q');
            //进入下一行放皇后
            backtrace(track, row+1);
            //撤销选择
            track.get(row).setCharAt(col,'.');
        }
    }
    // 是否可以在目标位置放皇后
    boolean isValid(ArrayList<StringBuilder> track, int row, int col){
        int  n = track.size();
        // 检查列是否有皇后冲突
        for(int i = 0; i < n; i++){
            if(track.get(i).charAt(col) == 'Q')
                return false;
        }
        // 检查右上方是否有皇后冲突
        for(int i = row-1, j = col+1; i>=0 && j <n; i--,j++){
            if(track.get(i).charAt(j) == 'Q')
                return false;
        }
        // 检查左上方是否有皇后冲突
        for(int i= row-1, j = col-1; i>=0 && j >=0; i--,j--){
            if(track.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
		Solution solution = new NQueens().new Solution();
	}
}
