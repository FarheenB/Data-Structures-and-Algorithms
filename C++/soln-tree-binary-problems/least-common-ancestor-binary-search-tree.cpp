/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(p->val<root->val && q->val<root->val){
            return lowestCommonAncestor(root->left,p,q); 
        }
        else if(p->val>root->val && q->val>root->val){
            return lowestCommonAncestor(root->right,p,q); 
        }
        else
            return root;
    }
};