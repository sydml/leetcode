package leetcode.editor.cn;

//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 堆 排序 分治算法 
// 👍 60 👎 0

public class SmallestKLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
        solution.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] heap;
        private int size;
        private int count;
        public int[] smallestK(int[] arr, int k) {
            heap = new int[k];
            if (k == 0) {
                return new int[0];
            }
            count = k;
            for (int i = 0; i < arr.length; i++) {
                if (size < count) {
                    heap[size] = arr[i];
                    int index = size;
                    while (Math.ceil(index / 2.0 - 1) >= 0 && heap[(int) Math.ceil(index / 2.0 - 1)] < heap[index]) {
                        int p = (int) Math.ceil(index / 2.0 - 1);
                        int temp = heap[p];
                        heap[p] = heap[index];
                        heap[index] = temp;
                        index = p;
                    }
                    size++;
                } else if (heap[0] > arr[i]) {
                    heap[0] = arr[i];
                    int p = 0;
                    while (true) {
                        int maxPos = p;
                        if (p * 2 + 1 < size && heap[p * 2 + 1] > heap[p]) {
                            maxPos = p * 2 + 1;
                        }
                        if (p * 2 + 2 < size && heap[p * 2 + 2] > heap[maxPos]) {
                            maxPos = p * 2 + 2;
                        }
                        if (maxPos == p) {
                            break;
                        }
                        int temp = heap[maxPos];
                        heap[maxPos] = heap[p];
                        heap[p] = temp;
                        p = maxPos;
                    }
                }
            }
            return heap;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
