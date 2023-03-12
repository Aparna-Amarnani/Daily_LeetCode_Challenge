/* Date-12/03/23
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
*/

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

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
        return null;
        int k=0;
        ListNode root=null;
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            {
                root=lists[i];
                k=i;
                break;
            }
        }
        if(root==null)
        return null;

        for(int i=k+1;i<lists.length;i++)
        {
            ListNode current=root;
            ListNode seclist=lists[i];
            // for first value
            if(seclist!=null&&seclist.val<=current.val)
            {
                ListNode node=new ListNode(seclist.val,current);
                root=node;
                current=root;
                seclist=seclist.next;
            }
            //for all values after the first value
            while(current.next!=null&&seclist!=null)
            {
              if(seclist.val<=current.next.val)
              {
                  ListNode node=new ListNode(seclist.val,current.next);
                  current.next=node;
                 
                  seclist=seclist.next;
                  
              }   
              else
              {
                  current=current.next;
              }
            }
            while(seclist!=null)
            {
                ListNode node=new ListNode(seclist.val);
                node.next=null;
                current.next=node;
                current=current.next;
                seclist=seclist.next;
            }
        }
        return root;
    }
}
