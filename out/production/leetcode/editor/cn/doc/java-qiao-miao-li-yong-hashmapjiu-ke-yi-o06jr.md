### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public int[] frequencySort(int[] nums) {
      HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Map.Entry<Integer,Integer>> arrayList=new ArrayList<>(map.entrySet());
        Collections.sort(arrayList,(o1,o2)-> o1.getValue().equals(o2.getValue()) ? (o2.getKey()-o1.getKey() ): (o1.getValue().compareTo(o2.getValue())));

        int[] res=new int[nums.length];
        int z=0;
        for(int i=0;i<arrayList.size();i++){
            for(int j=0;j<arrayList.get(i).getValue();j++){
                res[z++]=arrayList.get(i).getKey();
            }
        }
        return res;
    }
}
```