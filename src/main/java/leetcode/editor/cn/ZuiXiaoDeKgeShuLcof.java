package leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 242 👎 0

public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        int arr[] = new int[]{1,3,5,7,2,4,6,8};
        solution.getLeastNumbers(arr, 4);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] heap;
        private int size;
        private int count;

        public int[] getLeastNumbers(int[] arr, int k) {
            heap = new int[k];
            count = k;
            if (arr.length < k) {
                return arr;
            }else{
                for (int i = 0; i < arr.length; i++) {
                    add(arr[i]);
                }
            }
            return heap;
        }

        private void add(int val) {
            if (count == 0) {
                return;
            }
            if (size < count) {
                heap[size] = val;
                up(size);
                size++;

            } else if (heap[0] > val) {
                heap[0] = val;
                int pos = 0;
                while (true) {
                    int minPos = pos;
                    if (2 * pos + 1 < size && heap[2 * pos + 1] > heap[minPos]) {
                        minPos = 2 * pos + 1;
                    }
                    if (2 * pos + 2 < size && heap[2 * pos + 2] > heap[minPos]) {
                        minPos = 2 * pos + 2;
                    }
                    if (minPos == pos) {
                        break;
                    }
                    int temp = heap[minPos];
                    heap[minPos] = val;
                    heap[pos] = temp;
                    pos = minPos;
                }
            }
        }

        private void up(int index) {
            while (Math.ceil(index / 2.0 -1) >= 0 && heap[(int) Math.ceil(index / 2.0 -1)] < heap[index]) {
                int p = (int) Math.ceil(index / 2.0 - 1);
                int temp = heap[p];
                heap[p] = heap[index];
                heap[index] = temp;
                index = p;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

