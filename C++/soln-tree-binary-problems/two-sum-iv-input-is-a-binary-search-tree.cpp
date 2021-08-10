/**
 @author Farheen Bano

 Date 10-08-2021
  
 Reference-
 https://leetcode.com/problems/two-sum-iv-input-is-a-bst
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    set<int> nums_set;

    bool findTarget(TreeNode* root, int k) {     
        if(root==NULL)
            return false;
        return search(root,k);
    }
    
    bool search(TreeNode* root, int k){
        if(root==NULL)
            return false;
        
        if(nums_set.find(root->val)!=nums_set.end())
            return true;
        
        nums_set.insert(k-root->val);
        return search(root->left,k) || search(root->right,k); 
    }
};
