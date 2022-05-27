# class Solution:
#     def minSteps(self, s: str, t: str) -> int:
#         for ch in s:
# 		    # Find and replace only one occurence of this character in t
#             t = t.replace(ch, '', 1)
            
#         return len(t)

# class Solution:
#     def minSteps(self, s: str, t: str) -> int:
#         cnt = Counter(s)
#         for c in t:
#             cnt[c] -= 1
#         return sum(abs(c) for c in cnt.values())//2

class Solution:
    def minSteps(self, s: str, t: str) -> int:
        counter_s,counter_t = Counter(s), Counter(t)
        return sum(dict(counter_s-counter_t).values())