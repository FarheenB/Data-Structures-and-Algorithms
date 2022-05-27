class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        punctuation = "!?',;."

        for punc in punctuation:
            if punc in paragraph:
                paragraph = paragraph.replace(punc," ")

        P = paragraph.lower().split()
        mc = 0

        for words in P:
            if words not in banned and P.count(words) > mc:
                mc = P.count(words)
                word = words

        return(word)
