package leetcode.editor.cn;

import java.util.*;

/**
 * author: liuyuming
 * date: 2022-09-15 23:44:52
 */
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1189, 👎 0 
//
//
//
//

public class PermutationsIi{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            track.add(nums[i]);
            backtrack(nums);
            used[i]=false;
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

public static void main(String[] args) {
		Solution solution = new PermutationsIi().new Solution();
	}
}