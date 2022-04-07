package leetcode.editor.cn;

//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。 
//
// 请实现 KthLargest 类： 
//
// 
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。 
// int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
// 
//
// 
//提示：
//
// 
// 1 <= k <= 104 
// 0 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// -104 <= val <= 104 
// 最多调用 add 方法 104 次 
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素 
// 
// Related Topics 堆 设计 
// 👍 267 👎 0

public class KthLargestElementInAStream {
    public static void main(String[] args) {
//		Solution solution = new KthLargestElementInAStream().new Solution();
        int[] nums = new int[]{4,5,8,2};
        KthLargest largest = new KthLargest(3, nums);
        //[[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
        largest.add(3);
        largest.add(5);
        largest.add(10);
        largest.add(9);
        largest.add(4);

    }



}

//leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {
    // 堆排序解法 - 维护一个大小为k的小根堆, 若当前要插入的数小于等于堆顶元素, 则丢弃; 否则插入, 可以直接插入到堆顶, 在进行调整. 堆顶元素保存了第k大元素.
    // 创建一个小根堆
    private int[] heap;
    private int size = 0;
    private int count = 0;
    public KthLargest(int k, int[] nums) {
        heap = new int[k];
        count = k;

        // 初始化一个大小为k的小根堆
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }

    }

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

    // 自上向下调整堆
    public void down (int u) {
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

    // 自下向上调整堆
    public void up (int u) {
        // 存在父亲节点, 并且父亲节点的值大于当前值, 则进行交换
        while (Math.ceil((u / 2.0 - 1)) >= 0 && heap[(int)Math.ceil(u / 2.0 - 1)] > heap[u]) {
            int p = (int)Math.ceil(u / 2.0 - 1);
            int temp = heap[p];
            heap[p] = heap[u];
            heap[u] = temp;
            u = p;
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
