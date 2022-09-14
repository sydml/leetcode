package leetcode.editor.cn;
/**
 * author: liuyuming
 * date: 2022-05-18 15:43:39
 */
//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1580 👎 0

public class BinaryTreeMaximumPathSum{
	public static void main(String[] args) {
		Solution solution = new BinaryTreeMaximumPathSum().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	/*int res = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		int result = oneSideMax(root);
		return result;

	}
	int oneSideMax(TreeNode root) {
		if (root == null) return 0;
		int left = Math.max(0, oneSideMax(root.left));
		int right = Math.max(0, oneSideMax(root.right));
		// 后序位置
		res = Math.max(res, left + right + root.val);
		return Math.max(left, right) + root.val;
	}*/
	int pathSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		dfs(root);
		return pathSum;
	}
	// dfs 返回以该节点为端点的最大路径和

	public int dfs(TreeNode node) {
		if (node == null) return 0;
		int left = dfs(node.left);
		int right = dfs(node.right);
		// 当前节点有四个选择：
		// 1）独立成线，直接返回自己的值
		// 2）跟左子节点合成一条路径
		// 3）跟右子节点合成一条路径
		int ret = Math.max(node.val, node.val + Math.max(left, right));
		// 4）以自己为桥梁，跟左、右子节点合并成一条路径
		pathSum = Math.max(pathSum, Math.max(ret, node.val + left + right));
		return ret;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}