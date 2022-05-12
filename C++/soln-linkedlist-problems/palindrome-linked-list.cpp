/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/palindrome-linked-list/
 https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        stack<int> st;
        if(head==NULL || head->next==NULL)
            return true;
        ListNode* slow= head;
        ListNode* fast= head;
        while(fast!=NULL && fast->next!=NULL){
            st.push(slow->val);
            slow =slow->next;
            fast =fast->next->next;           
        }    
    
        if(fast!=NULL)
            slow=slow->next;
    
        while(slow!=NULL){
            if(st.empty())
            {
                return false;
            }
            int num=st.top();
            st.pop();
            if(slow->val!=num){
                return false;
            }
            slow=slow->next;
        }
        return true;
    }
};