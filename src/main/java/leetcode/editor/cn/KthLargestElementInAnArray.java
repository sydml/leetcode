package leetcode.editor.cn;
/**
 * author: liuyuming
 * date: 2022-05-05 20:26:39
 */
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1651 👎 0

public class KthLargestElementInAnArray{
	public static void main(String[] args) {
		Solution solution = new KthLargestElementInAnArray().new Solution();
		int kthLargest = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 4);
		System.out.println(kthLargest);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
		heap = new int[k];
		count = k;

		// 初始化一个大小为k的小根堆
		int result =0;
		for (int i = 0; i < nums.length; i++) {
			result = add(nums[i]);
		}
		return result;
	}
	private int[] heap;
	private int size = 0;
	private int count = 0;

	public int add(int val) {
		if (size < count) {
			heap[size] = val;
			up(size);
			size++;
		} else if (heap[0] < val) {
			heap[0] = val;
			down(0);
		}
		return heap[0];
	}

	// 自下向上调整堆
	public void up(int u) {
		// 存在父亲节点, 并且父亲节点的值大于当前值, 则进行交换
		while (Math.ceil((u / 2.0 - 1)) >= 0 && heap[(int) Math.ceil(u / 2.0 - 1)] > heap[u]) {
			int p = (int) Math.ceil(u / 2.0 - 1);
			int temp = heap[p];
			heap[p] = heap[u];
			heap[u] = temp;
			u = p;
		}
	}

	// 自上向下调整堆
	public void down(int u) {
        /*int t = u;
        if (2 * u + 1 < size && heap[2 * u + 1] < heap[t])
            t = 2 * u + 1;
        if (2 * u + 2 < size && heap[2 * u + 2] < heap[t])
            t = 2 * u + 2;
        if (t != u) {
            int temp = heap[u];
            heap[u] = heap[t];
            heap[t] = temp;
            down (t);
        }*/
		int start = u;
		while (true) {
			int minPos = start;
			if ((2 * start + 1) < size && heap[2 * start + 1] < heap[minPos]) {
				minPos = 2 * start + 1;
			}
			if ((2 * start + 2) < size && heap[2 * start + 2] < heap[minPos]) {
				minPos = 2 * start + 2;
			}
			if (minPos == start) {
				break;
			}
			int temp = heap[start];
			heap[start] = heap[minPos];
			heap[minPos] = temp;
			start = minPos;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}