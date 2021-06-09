### 解题思路
频次高位，原值取反（降序），拼接正数。排序后还原原值

### 代码

```java
class Solution {
    public int[] frequencySort(int[] nums) {
        int[] cnts = new int[201];
        for (int n : nums){
            cnts[n + 100] ++;
        }
        for (int i = 0; i < nums.length; i ++){
            nums[i] = 10000 * cnts[nums[i] + 100] - nums[i] + 100;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i ++){
            nums[i] = 100 - nums[i] % 10000 ;
        }

        return nums;
    }
}
```