### 解题思路
根据提示中的-100 <= nums[i] <= 100我们可以想到桶排序
使用桶排序统计元素出现的次数
定义counts数组统计元素出现的次数
已知条件为-100 <= nums[i] <= 100，又数组的下标大于0，所以nums[i]必须转换为大于0的元素，故统计nums[i]+100的次数
数组的大小为201，这样才能囊括[0,200]的数字，进而统计其出现次数
当统计完nums数组中元素出现的次数以后，我们需要根据元素出现的次数重新定义元素的大小
这个新的大小定义为新数
新数就相当于满足题意得元素得最终大小，然后对其排序后，再还原就是最终的结果数组

那么如何定义新数？
首先我们考虑，元素是按照出现的次数升序排列，那么出现的次数在新数中占比要比元素本身要大，
在统计的过程我们计算的是[0,200]元素的次数所以元素最大值为200，
只要使用一个大于这个最大值的元素去乘以元素出现的次数，那么元素出现的次数在新数中占比就超过了元素的大小，符合按次数升序排序
此外，还要考虑次数相同按数值降序排列，
那么在新数中次数占比相同时，nums[i]越大，那么其在新数中的数值就应该越小，这很容易实现，我们通过减法就可以实现
当然不能直接减nums[i]，因为刚开始的时候我们算的是nums[i]+100的范围，所以这里我们也必须再+100，保证变换数据的准确性
(如果刚开始我们统计的是nums[i]+200的次数，那么这个地方就需要改为+200，以保证数据的准确性)

那么最终的规则就是：新数 = 201 * counts[nums[i] + 100] + 100 - nums[i]
通过上述规则可以得到新数对应的数组，新数的大小就对应最终的结果的大小

对新数数组按升序排序，就可以得到最终的排序结果，但是还没完，我们需要把新数按照规则再还原回去，这样才圆满完成任务

如何还原呢？
通过转换的规则可以得出还原的规则：100 - 新数 % 201
通过这个规则转换以后就是最终的结果。

### 参考
[双百Java](https://leetcode-cn.com/problems/sort-array-by-increasing-frequency/solution/shuang-bai-java-by-remy-4/)

### 代码

```java
class Solution {
    public int[] frequencySort(int[] nums) {
        int[] cnts = new int[201];
        for (int n : nums){
            cnts[n + 100] ++;
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = 201 * cnts[nums[i] + 100] - nums[i] + 100;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            nums[i] = 100 - nums[i] % 201;
        }
        return nums;
    }
}
```