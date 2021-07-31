/**
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/symmetric-tree/
 https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
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
    bool isSymmetric(TreeNode* root) {
        return isMirror(root,root);
    }
    
    bool isMirror(TreeNode* R1, TreeNode* R2){        
        //exit conditions        
        if(R1==NULL && R2==NULL)
            return true;
        if(R1==NULL || R2==NULL)
            return false;
        
        return (R1->val==R2->val)
            && isMirror(R1->left,R2->right)
            && isMirror(R1->right,R2->left);       
    }
};