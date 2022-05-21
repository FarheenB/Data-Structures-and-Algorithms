# https://leetcode.com/problems/first-unique-character-in-a-string
import collections
class Solution:
    def firstUniqChar(self, s: str) -> int:
        dic = {}
        stack = collections.deque([])
        for i in range(len(s)):
            if s[i] in dic:
                dic[s[i]] = -1
            else:
                dic[s[i]] = i
                stack.append(s[i])
        while stack:
            item = stack.popleft()
            if dic[item] != -1:
                return dic[item]
        return -1