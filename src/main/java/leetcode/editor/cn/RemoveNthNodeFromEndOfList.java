package leetcode.editor.cn;
/**
 * author: liuyuming
 * date: 2022-03-31 23:06:06
 */
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//运行失败: [1,2,3,4,5] 2 is not a valid value of type ListNode 测试用例:[1,2,3,4,5] 2 stdout: null
// 解答失败: 测试用例:[1,2,3,4,5] 2 测试结果:[5] 期望结果:[1,2,3,5] stdout:
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1926 👎 0

public class RemoveNthNodeFromEndOfList{
	public static void main(String[] args) {
		Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		solution.removeNthFromEnd(head, 2);
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 虚拟头结点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		// 删除倒数第 n 个，要先找倒数第 n + 1 个节点
		ListNode x = findFromEnd(dummy, n + 1);
		// 删掉倒数第 n 个节点
		x.next = x.next.next;
		return dummy.next;
	}

	private ListNode findFromEnd(ListNode head, int k) {
		ListNode p1 = head;
		// p1 先走 k 步
		for (int i = 0; i < k; i++) {
			p1 = p1.next;
		}
		ListNode p2 = head;
		// p1 和 p2 同时走 n - k 步
		while (p1 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		// p2 现在指向第 n - k 个节点
		return p2;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}