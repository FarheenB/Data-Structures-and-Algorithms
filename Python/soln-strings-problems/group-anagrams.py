# class Solution:
#     def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
#         d = {}
#         for w in sorted(strs):
#             key = tuple(sorted(w))
#             d[key] = d.get(key, []) + [w]
#         return d.values()

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        h = {}
        for word in strs:
            sortedWord = ''.join(sorted(word))
            if sortedWord not in h:
                h[sortedWord] = [word]
            else:
                h[sortedWord].append(word)
        final = []
        for value in h.values():
            final.append(value)
        return final