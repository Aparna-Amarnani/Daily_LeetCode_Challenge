/* Date-14/03/23
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.*/



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
    int sum=0;
    public void traverse(TreeNode root,int val)
    {
        if(root==null)
        return;

        val=val*10+root.val;
        if(root.left==null&&root.right==null)
        {
            sum=sum+val;
        }

        traverse(root.left,val);
        traverse(root.right,val);
    }
    public int sumNumbers(TreeNode root) {
        traverse(root,0);
        return sum;
    }
}
