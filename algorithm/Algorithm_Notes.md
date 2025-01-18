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

