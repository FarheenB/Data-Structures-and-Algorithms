/**
 * @author Farheen Bano
  
 * References-
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        if(root==NULL){
            return result;
        }
        
        queue<TreeNode *> qu;
        qu.push(root);
        while(!qu.empty()){
            result.push_back(qu.front()->val);

            int size=qu.size();
            
            for(int i=0;i<size;i++){
                TreeNode* node=qu.front();
                qu.pop();
            
                if(node->right!=NULL)
                    qu.push(node->right);      
                if(node->left!=NULL)
                    qu.push(node->left);

            }
          
        }
        return result;
    }
};