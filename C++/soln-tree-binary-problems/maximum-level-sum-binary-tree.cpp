/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/
 https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
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
    int maxLevelSum(TreeNode* root) {
 
        if(root==NULL){
            return -1;
        }
        
        int max_sum=INT_MIN;
        int level=0;
        int cur_level=0;
            
        queue<TreeNode *> qu;
        qu.push(root);
        while(!qu.empty()){
            int size=qu.size();
            cur_level++;
            
            int cur_sum=0;            
            for(int i=0;i<size;i++){
                TreeNode* node=qu.front();
                qu.pop();
                cur_sum+=node->val;
                   
                if(node->left!=NULL)
                    qu.push(node->left);
                if(node->right!=NULL)
                    qu.push(node->right);
            }
            if(max_sum<cur_sum){
                max_sum=cur_sum;
                level=cur_level;
            }

        }
        return level;
    }
};