package leetcode.editor.cn;
/**
 * author: liuyuming
 * date: 2022-09-16 23:33:01
 */
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1376, 👎 0 
//
//
//
//

public class MaximumDepthOfBinaryTree{
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
    int depth=0;
    int res = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            res = Math.max(res, depth);
            return;
        }
        depth++;
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

public static void main(String[] args) {
		Solution solution = new MaximumDepthOfBinaryTree().new Solution();
	}
}