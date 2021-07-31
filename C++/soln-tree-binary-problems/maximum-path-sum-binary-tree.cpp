/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    int max_sum=INT_MIN;

    int maxPathSum(TreeNode* root) {
        if(root==NULL)
            return 0;
        dfs(root);
        return max_sum;
    }
        
    int dfs(TreeNode* root){
        if(root==NULL)
            return 0;
        
        int left=dfs(root->left);
        int right=dfs(root->right);
        
        int ans=max(left+right+root->val,root->val);
        int temp=max(max(left,right)+root->val,root->val);
        max_sum=max(max_sum,max(temp,ans));
        
        return temp;    
    }
};