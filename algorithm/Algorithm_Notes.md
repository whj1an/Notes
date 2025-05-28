## (M) 3. [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

> Given a string `s`, find the length of the **longest** 
>
> **substring**
>
>  without repeating characters.
>
> 
>
>  
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

