package leetcode.editor.cn;
/**
 * author: liuyuming
 * date: 2022-09-15 22:36:17
 */
//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 900 👎 0

public class ZhongJianErChaShuLcof{
	public static void main(String[] args) {
		Solution solution = new ZhongJianErChaShuLcof().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length - 1,
				inorder, 0, inorder.length - 1);

    }
	TreeNode build(int[] preorder, int preStart, int preEnd,
				   int[] inorder, int inStart, int inEnd) {

		if (preStart > preEnd) {
			return null;
		}

		// root 节点对应的值就是前序遍历数组的第一个元素
		int rootVal = preorder[preStart];
		// rootVal 在中序遍历数组中的索引
		int index = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == rootVal) {
				index = i;
				break;
			}
		}

		int leftSize = index - inStart;

		// 先构造出当前根节点
		TreeNode root = new TreeNode(rootVal);
		// 递归构造左右子树
		root.left = build(preorder, preStart + 1, preStart + leftSize,
				inorder, inStart, index - 1);

		root.right = build(preorder, preStart + leftSize + 1, preEnd,
				inorder, index + 1, inEnd);
		return root;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}