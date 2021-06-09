### 方法一：动态维护一个大小为 k 的最小堆，返回堆顶元素即可。
#
### 先放 Java 代码，思路简单易懂，具体注释已写好在代码中。
```java
class KthLargest {
    int k;
    int[] nums;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length && i < k; ++i) {
            // 将 nums 的前 k 个数（如有）入堆
            this.minHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; ++i) {
            // 将 nums 剩余的数（如有）依次和堆顶元素比较
            // 动态维护堆的 size 为 k
            if (nums[i] > this.minHeap.peek()) {
                this.minHeap.poll();
                this.minHeap.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        int res = val;

        if (minHeap.size() < k) {
            // 如果此时堆的 size 还没到 k，直接将 val 入堆
            minHeap.add(val);
        } else {
            // 否则将 val 和堆顶元素比较来决定是否入堆
            if (val > this.minHeap.peek()) {
                this.minHeap.poll();
                this.minHeap.add(val);
            }
        }

        res = minHeap.peek();

        return res;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
```
### 执行结果截图：
![image.png](https://pic.leetcode-cn.com/1613047917-xQhyUl-image.png)
#
### 年三十啦！祝大家牛年快乐呀，新的一年拿下硬核 offer！
#
### Tracker
1. 1刷：2021/02/11