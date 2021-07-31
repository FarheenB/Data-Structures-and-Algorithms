/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/path-sum-ii/

 Note: Find all root to leaf path equals to sum
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

    vector<vector<int>> result;

    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int>temp;
        solve(root,0,targetSum,temp);
        return result;
    }
    
    
    void solve(TreeNode* root, int currentSum ,int target, vector<int>&temp)
    {
        if(root==NULL)
          return; // Base Case

        temp.push_back(root->val);
        currentSum+=root->val;

        if(root->left==NULL && root->right==NULL && currentSum==target){
            result.push_back(temp);
            temp.pop_back();
            return;
        }

        solve(root->left,currentSum,target,temp);
        solve(root->right,currentSum,target,temp);
        temp.pop_back();
    }
};