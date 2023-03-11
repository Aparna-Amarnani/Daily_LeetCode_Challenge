/* Date-11/03/23
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode bst(List<Integer> arr, int start, int end)
    {
        if(start>end)
        return null;

        int mid=(start+end)/2;
        TreeNode root=new TreeNode(arr.get(mid));
        root.left=bst(arr,start,mid-1);
        root.right=bst(arr,mid+1,end);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        List<Integer> arr=new ArrayList<>();
        while(head!=null)
        {
            arr.add(head.val);
            head=head.next;
        }

        return bst(arr,0,arr.size()-1);
    }
}
