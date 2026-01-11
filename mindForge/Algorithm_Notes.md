## 1. Two Sum
Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have **_exactly_ one solution**, and you may not use the _same_ element twice.

You can return the answer in any order.

**Example 1:**

**Input:** `nums = [2,7,11,15]`, target = 9
**Output:** ``[0,1]``
**Explanation:** Because `nums[0] + nums[1] == 9`, we return `[0, 1]`.

**Example 2:**

**Input:** `nums = [3,2,4], target = 6`
**Output:** `[1,2]`

**Example 3:**

**Input:** `nums = [3,3], target = 6`
**Output:** `[0,1]`

**Constraints:**

- `2 <= nums.length <= 104`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`
- **Only one valid answer exists.**

### Solutions
Python Solution:

Java Solution:
1.
```java
// solution but will be overtime
class Solution {
	public int[] twoSum(int [] nums, int target) {
		int[] result = new int[2];
		for(int i = 0; i < nums.lenth; i++){
			for (int j = i + 1; j < nums.length; j++){
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
	}
	return result;
}
```
2.
```java
package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// 这个方法复杂度为O(n)，只有一个for循环
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // 创建一个哈希表
        for (int i = 0; i < nums.length; i++) { 
            int comp = target - nums[i]; // 将当前的值的差记录
            if (map.containsKey(comp)) { // 如果标中存在这个值，那么返回这个值的键
                return new int[]{map.get(comp), i};
            }
            map.put(nums[i], i); // 如果没有，那么就讲这个值和对应的键存入到哈希表中
        }
        return null;
    }

}
```

==black box TEST==

```java
package leetcode.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void testExample1() {
        TwoSum ts = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = ts.solution(nums, target);

        assertArrayEquals(new int[]{0, 1}, result); //此方法用于
    }

    @Test
    void testExample2() {
        TwoSum ts = new TwoSum();
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = ts.solution(nums, target);

        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testDuplicateValues() {
        TwoSum ts = new TwoSum();
        int[] nums = {3, 3};
        int target = 6;

        int[] result = ts.solution(nums, target);

        assertArrayEquals(new int[]{0, 1}, result);
    }
}

```




## 2. Add Two Numbers
You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Example 1:**

**Input:** l1 = [2,4,3], l2 = [5,6,4]
**Output:** [7,0,8]
**Explanation:** 342 + 465 = 807.

**Example 2:**

**Input:** l1 = [0], l2 = [0]
**Output:** [0]

**Example 3:**

**Input:** l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
**Output:** [8,9,9,9,0,0,0,1]


### Solutions
Java Solution
```java
package leetcode.medium;


public class AddTwoNumbers {
    public ListNode solution (ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return dummy.next;
    }
}

```

**Test**

```java
package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AddTwoNumbers 的单元测试类
 * 目的：
 * 1. 验证链表加法的正确性
 * 2. 覆盖常见情况、边界情况和进位情况
 * 3. 保证以后重构 solution 方法时行为不被破坏
 */
class AddTwoNumbersTest {

    /**
     * 测试 LeetCode 官方示例：
     * (2 -> 4 -> 3) + (5 -> 6 -> 4) = (7 -> 0 -> 8)
     * 对应数值：342 + 465 = 807
     */
    @Test
    void testExampleCase() {
        // 创建被测试对象
        AddTwoNumbers solution = new AddTwoNumbers();

        // 构造输入链表 l1 = [2, 4, 3]
        ListNode l1 = buildList(2, 4, 3);

        // 构造输入链表 l2 = [5, 6, 4]
        ListNode l2 = buildList(5, 6, 4);

        // 调用被测试的方法
        ListNode result = solution.solution(l1, l2);

        // 验证结果链表是否等于 [7, 0, 8]
        assertListEquals(result, 7, 0, 8);
    }

    /**
     * 测试两个链表长度不相等的情况
     * (9 -> 9) + (1) = (0 -> 0 -> 1)
     * 对应数值：99 + 1 = 100
     */
    @Test
    void testDifferentLengthLists() {
        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode l1 = buildList(9, 9);
        ListNode l2 = buildList(1);

        ListNode result = solution.solution(l1, l2);

        assertListEquals(result, 0, 0, 1);
    }

    /**
     * 测试连续进位的情况
     * (9 -> 9 -> 9) + (1) = (0 -> 0 -> 0 -> 1)
     * 对应数值：999 + 1 = 1000
     */
    @Test
    void testCarryAtEnd() {
        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode l1 = buildList(9, 9, 9);
        ListNode l2 = buildList(1);

        ListNode result = solution.solution(l1, l2);

        assertListEquals(result, 0, 0, 0, 1);
    }

    // =========================
    // ===== 辅助工具方法 =====
    // =========================

    /**
     * 根据给定的整数序列构造链表
     * 例如：
     * buildList(2, 4, 3) 会生成：
     * 2 -> 4 -> 3 -> null
     * 这个方法的存在意义：
     * - 避免在每个测试中手写链表构造逻辑
     * - 让测试代码更简洁、更可读
     */
    private ListNode buildList(int... values) {
        // dummy 节点用于简化链表构造逻辑
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 遍历输入值，逐个创建节点并连接
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        // 返回真正的头结点（跳过 dummy）
        return dummy.next;
    }

    /**
     * 验证链表的值序列是否与期望值一致
     * 例如：
     * assertListEquals(result, 7, 0, 8)
     * 这个方法的存在意义：
     * - 不关心链表结构，只关心“结果是否正确”
     * - 一旦失败，可以精确定位是哪一位不对
     */
    private void assertListEquals(ListNode node, int... expected) {
        int index = 0;

        // 同时遍历链表和期望数组，逐个比较值
        while (node != null && index < expected.length) {
            assertEquals(
                    expected[index],
                    node.val,
                    "Mismatch at index " + index
            );
            node = node.next;
            index++;
        }

        // 如果链表还有剩余节点，说明结果多了
        assertNull(node, "Result list is longer than expected");

        // 如果期望数组还有剩余值，说明结果少了
        assertEquals(
                expected.length,
                index,
                "Result list is shorter than expected"
        );
    }
}
```





## 3. [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

> Given a string `s`, find the length of the **longest** 
>
> **substring**
>
> without repeating characters.
>
> **Example 1:**
>
> ```
> Input: s = "abcabcbb"
> Output: 3
> Explanation: The answer is "abc", with the length of 3.
> ```
>
> **Example 2:**
>
> ```
> Input: s = "bbbbb"
> Output: 1
> Explanation: The answer is "b", with the length of 1.
> ```
>
> **Example 3:**
>
> ```python
> Input: s = "pwwkew"
> Output: 3
> Explanation: The answer is "wke", with the length of 3.
> Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
> ```

### Solution

java
```java
import java.util.HashMap;  
import java.util.Map;  
  
public class Solution {
    public int[] twoSum(int[] nums, int target) {  
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
  
        for (int i = 0; i < nums.length; i++) {  
            int comp = target - nums[i];  
            if (map.containsKey(comp)) {  
                return new int[]{map.get(comp), i};  
            }  
            map.put(nums[i], i);  
        }  
        return null;  
    }  
}
```

python
```python
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        initial_set = set()
        max_len = 0
        left_point = 0

        for i in range(len(s)):
            while s[i] in initial_set:
                initial_set.remove(s[left_point])
                left_point += 1
            initial_set.add(s[i])
            max_len = max(max_len, i - left_point + 1)
        return max_len
```


## 7. Reverse Integers

Given a signed 32-bit integer `x`, return `x` _with its digits reversed_. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-231, 231 - 1]`, then return `0`.

**Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**

**Example 1:**

**Input:** x = 123
**Output:** 321

**Example 2:**

**Input:** x = -123
**Output:** -321

**Example 3:**

**Input:** x = 120
**Output:** 21

### Solutions
```java
class Solution{
	public int reverse(int x){
		int res = 0;
		
		while (x != 0){
			int digit = x % 10;
			x /= 10;
			
			if (res > Integer.MAX_VALUE / 10 ||
				(res == Integer.MAX_VALUE / 10 && digit < 7)) return 0;
				
			return res * 10 + digit;
			}
		}



}
```



## 14. Longest Common Prefix

> Write a function to find the longest common prefix string amongst an array of strings.
>
> If there is no common prefix, return an empty string `""`.
>
> **Example 1:**
>
> ```
> Input: strs = ["flower","flow","flight"]
> Output: "fl"
> ```
>
> **Example 2:**
>
> ```
> Input: strs = ["dog","racecar","car"]
> Output: ""
> Explanation: There is no common prefix among the input
> ```

### Solutions
java

```java
class Solution {
	public ListNode addTwoNumbers(ListNode l1, lListNode l2){
		
	}
}
```

Python:

```python
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs:
            return ''
        prefix_str = strs[0]
        for ele in strs[1:]:
            while not ele.startswith(prefix_str):
                prefix_str = prefix_str[:-1]
                if not prefix_str:
                    return ''
        return prefix_str
```





## 20. Valid Parentheses

> Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.
>
> An input string is valid if:
>
> 1. Open brackets must be closed by the same type of brackets.
> 2. Open brackets must be closed in the correct order.
> 3. Every close bracket has a corresponding open bracket of the same type.
>
> **Example 1:**
>
> **Input:** s = "()"
>
> **Output:** true
>
> **Example 2:**
>
> **Input:** s = "()[]{}"
>
> **Output:** true
>
> **Example 3:**
>
> **Input:** s = "(]"
>
> **Output:** false
>
> **Example 4:**
>
> **Input:** s = "([])"
>
> **Output:** true
>
> **Constraints:**
>
> - `1 <= s.length <= 104`
> - `s` consists of parentheses only `'()[]{}'`.



### Solution

Python

```python
class slotion(object):
    def isValid(self, s):
        cache = []
        b_dict = {')':'(',']':'[','}':'{'}
        
        for char in s:
            if char in b_dict:
                first_ele = cache.pop() if cache else '#'
                if b_dict[char] != first_ele:
                    return False
            else:
                cache.append(char)
        return not cache
```





## 88 Merge Sorted Array

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

**Merge** `nums1` and `nums2` into a single array sorted in **non-decreasing order**.

The final sorted array should not be returned by the function, but instead be *stored inside the array* `nums1`. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.

 

**Example 1:**

```
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
```

**Example 2:**

```
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
```

**Example 3:**

```
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
```

 

**Constraints:**

- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `1 <= m + n <= 200`
- `-109 <= nums1[i], nums2[j] <= 109`

 

**Follow up:** Can you come up with an algorithm that runs in `O(m + n)` time?



### Solution



```java
```









## 5. [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

Given a string `s`, return *the longest* *palindromic* *substring* in `s`.

 

**Example 1:**

```
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
```

**Example 2:**

```
Input: s = "cbbd"
Output: "bb"
```

 

**Constraints:**

- `1 <= s.length <= 1000`
- `s` consist of only digits and English letters.

### Solutions

Java:

```java

```

C++:

```cpp
#include <iostream>
#include <string>
#include <utility>

using namespace std;

class Solution {

public:
	string longestPalindrome(string s) {
		int n = s.size();
		if (n < 2) return s;

		int bestL = 0, bestR = 0;

		for (int i = 0; i < n; i++) {
			auto [l1, r1] = expand(s, i, i);
			auto [l2, r2] = expand(s, i, i + 1);

			if (r1 - l1 > bestR - bestL) {
				bestL = l1; bestR = r1;
			}

			if (r2 - l2 > bestR - bestL) {
				bestL = l2; bestR = r2;
			}
		}
		return s.substr(bestL, bestR - bestL + 1);
	}

private:
	pair<int, int> expand(const string& s, int left, int right) {
		int n = s.size();
		//只要左右字符相等，就继续扩展
		while (left >= 0 && right < n && s[left] == s[right]) {
			left--; right++;
		}
		return { left + 1, right - 1 };
	}
};
 
int main() {
	Solution sol;
	string input;
	// 从标准输入读取一行字符串
	if (getline(cin, input)) {
		string ans = sol.longestPalindrome(input);
		cout << "Longest palindrome substring: " << ans << endl;
	}
	return 0;
}
```

## [6. Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/)

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```
string convert(string s, int numRows);
```

 

**Example 1:**

```
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
```

**Example 2:**

```
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
```

**Example 3:**

```
Input: s = "A", numRows = 1
Output: "A"
```

 

**Constraints:**

- `1 <= s.length <= 1000`
- `s` consists of English letters (lower-case and upper-case), `','` and `'.'`.
- `1 <= numRows <= 1000`

Python Solution:

```python
class Solution(object):

    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        # 如果只要给出一行，那么直接输出，如果要求行数比总字数多，也直接输出
        if numRows == 1 or numRows >= len(s):
            return s

		# 创建numRows个子列
        subRows = [''] * numRows
        cur_row = 0 # 初始化当前行为0
        going_down = False # 判断是否换行

        for c in s:
            subRows[cur_row] += c
            
            if cur_row == 0 or cur_row == numRows - 1:
                going_down = not going_down
  
            cur_row += 1 if going_down else -1

        return "".join(subRows)
```

