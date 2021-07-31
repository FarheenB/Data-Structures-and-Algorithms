/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/level-order-tree-traversal/
 https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root==NULL){
            return result;
        }
        
        queue<TreeNode *> qu;
        qu.push(root);
        while(!qu.empty()){
            int size=qu.size();
            vector<int> list;
            
            for(int i=0;i<size;i++){
                TreeNode* node=qu.front();
                qu.pop();
                
                list.push_back(node->val);
                
                if(node->left!=NULL)
                    qu.push(node->left);
                if(node->right!=NULL)
                    qu.push(node->right);
            }
            result.push_back(list);
        }
        return result;
    }
};