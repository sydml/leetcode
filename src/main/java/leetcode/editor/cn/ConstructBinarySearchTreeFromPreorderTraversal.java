package leetcode.editor.cn;
/**
 * author: liuyuming
 * date: 2022-09-24 19:06:30
 */
//给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。 
//
// 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。 
//
// 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大
//于 Node.val。 
//
// 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [8,5,1,7,10,12]
//输出：[8,5,10,1,7,null,12]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1,3]
//输出: [1,null,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 10^8 
// preorder 中的值 互不相同 
// 
//
// 
//
// Related Topics 栈 树 二叉搜索树 数组 二叉树 单调栈 👍 235 👎 0

public class ConstructBinarySearchTreeFromPreorderTraversal{
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    // 定义：将 preorder[start..end] 区间内的元素生成 BST，并返回根节点
    private TreeNode build(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        // 根据前序遍历的特点，根节点在第一位，后面接着左子树和右子树
        int rootVal = preorder[start];
        TreeNode root = new TreeNode(rootVal);

        // 根据 BST 的特点，左子树都比根节点的值小，右子树都比根节点的值大
        // p 就是左右子树的分界点
        int p = start + 1;
        while (p <= end && preorder[p] < rootVal) {
            p++;
        }
        // [start+1, p-1] 区间内是左子树元素
        root.left = build(preorder, start + 1, p - 1);
        // [p, end] 区间内是右子树元素
        root.right = build(preorder, p, end);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
	    Solution solution = new ConstructBinarySearchTreeFromPreorderTraversal().new Solution();
	}
}