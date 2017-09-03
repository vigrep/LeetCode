# Two Sum 
LeetCode链接：[Two Sum](https://leetcode.com/problems/two-sum/description/)
### 问题描述
给定一个整形数组和一个target(int), 要求输出该数组中任意两个元素相加为target的元素的索引。

注：假定只有一个正确答案，并且数组中不会出现相同的元素.

**举例：**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

## Approach #1 (Brute Force)

循环遍历每一个元素x，判断其他元素y是否满足：x + y = target,满足条件，返回x、y的下标

复杂度分析：

- 时间复杂度：O(n
- 空间复杂度：
