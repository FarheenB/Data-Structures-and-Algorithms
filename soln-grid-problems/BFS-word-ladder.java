/*
https://www.interviewbit.com/problems/word-ladder-i/
https://leetcode.com/problems/word-ladder/
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        
        for(String word:wordList){
            set.add(word);
        }
        
        if(!set.contains(endWord))
            return 0;
            
        Queue<String> queue=new LinkedList<>();
        
        queue.offer(beginWord);
        int level=1;
        
        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=1;i<=size;i++)
            {
                String cur_word=queue.poll();
                char word_ch[]=cur_word.toCharArray();
                
                for(int j=0;j<word_ch.length;j++){
                    char original_ch=word_ch[j];
                    
                    for(char l='a'; l<='z'; l++){
                        if(word_ch[j]==l)
                            continue;
                        word_ch[j]=l;
                        String new_word=String.valueOf(word_ch);
                        if(new_word.equals(endWord))
                                return level+1;
                        if(set.contains(new_word)){
                            queue.offer(new_word);
                            set.remove(new_word);
                        }
                    }
                    word_ch[j]=original_ch;
                }                
            }           
            level++;
        }
        return 0;       
    }
}