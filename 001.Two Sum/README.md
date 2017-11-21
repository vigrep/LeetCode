# Two Sum 
LeetCode链接：[Two Sum](https://leetcode.com/problems/two-sum/description/)
[返回到主页列表](../README.md)
# 问题描述
给定一个整形数组和一个target(int), 要求输出该数组中任意两个元素相加为target的元素的索引。

注：假定只有一个正确答案，并且数组中不会出现相同的元素.

**举例：**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

# Approach #1 (Brute Force)
两层循环, 挨个判断。

外层循环遍历每一个元素x，内层循环判断除x外的其他元素y是否满足条件：x + y = target，满足条件，返回x、y的下标

#### 复杂度分析：
- 时间复杂度：O(n^2)
- 空间复杂度：O(1)

# Approach #2 (Two-pass Hash Table)
使用Hash来减少查找时间。Hash表查询的平均时间复杂度近乎O(1)[最差情况下是O(n)]
1. 将数组中的每一个元素，存放到HashMap中,其中：key为数组中的元素，value为元素在数组中的下标
2. 循环遍历数组中的元素x，通过HashMap.containsKey() 方法来判断是否含有key(target - x)

#### 判断条件分析:
因为该方法**先将数组元素存放进HashMap, 再查找, 查找前，数组中的所有元素都已经存放到了HashMap中，**
所以需要同时满足以下2个条件才能返回结果:
- 条件1: key存在
- 条件2：通过key获取到的value不等于i(当前循环的索引) : (为了防止遇到3+3=6这种情况时出错)

#### 返回结果分析:
[i, HashMap.get(key)]

#### 复杂度分析：
- 时间复杂度：O(n)
- 空间复杂度：O(n) 使用了HashMap

# Approach #3 (One-pass Hash Table)
在方法2的基础上进一步优。

方法3和方法2不同之处：
- 方法2: 先将数组元素存储到HashMap后，再进行查找
- 方法3: 在迭代的同时，将数组中的元素存储到HashMap

#### 判断条件分析:
因为该方法采用**边迭代边存储，在HashMap中查找时，元素并没有存放进HashMap, 元素是在查找完之后放入HashMap的，**
所以只需要满足条件: key存在即可。

#### 返回结果分析:
因为**当前迭代的元素是在查找完后，才放入HashMap的，**HashMap.get(key)得到的索引值肯定小于i

所以返回结果：[HashMap.get(key), i]

#### 复杂度分析：
- 时间复杂度：O(n)
- 空间复杂度：O(n) 使用了HashMap

# 总结
1. 在查找某一元素时，可以考虑使用Hash表来降低时间复杂度。但是需要花费额外的空间。
2. 数组存放到Hash表中时，应将元素作为key, 下标作为value。
3. 链接：[Hash表时间复杂度分析](https://stackoverflow.com/questions/9214353/hash-table-runtime-complexity-insert-search-and-delete)
4. **给定的条件要学会各种变换:** 就本题给定的条件 x+y=target 来说，如果你看重条件的某一部分，比如`x+y=`部分的话，也许你想不到可以将条件转换成`target-x=y`，而在第2、3方法中进行判断时就会各种蹩脚。
5. 数组访问元素时间复杂度是O(1), 即数组的大小对此并无影响. 
