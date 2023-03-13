/* Date-10/03/23
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean traverse(TreeNode left,TreeNode right)
    {
        if(left==null&&right==null)
        {
            return true;
        }
        else if(left==null||right==null)
        {
            return false;
        }
        else
        {
            return (left.val==right.val)&&traverse(left.left,right.right)&&traverse(left.right,right.left);
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return false;
        else
        {
            return traverse(root.left,root.right);
        }
    }
}
