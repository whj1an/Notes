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
				if (nums[i] + nums[j] = target) {
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

==Main==

```java
package q1_twosum;  
  
import java.util.Arrays;  

/**
因为上面Solution方法不是static类型，所以在测试时需要实例化
*/
public class Main {  
    public static void main(String[] args) {  
        int[] nums = {1, 2, 4, 11, 3};  
        int target = 3;  
  
        Solution sol = new Solution();  
        int[] result = sol.twoSum(nums, target);  
        System.out.println(Arrays.toString(result));  
    }  
}
```


## 2. Add Two Numbers
You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg)

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
class Solution{
	public 
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