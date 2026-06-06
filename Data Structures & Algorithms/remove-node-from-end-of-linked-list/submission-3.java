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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz=0;
        ListNode temp=head;
        while(temp!=null)
        {
            sz++;
            temp=temp.next;
        }
        if(sz-n==0)
        {
            return head.next;
        }
        System.out.println(sz);
        int r=sz-n;
        ListNode left=head;
        ListNode right=head;
        for(int i=1;i<=r-1;i++)
        {
            left=left.next;
        }
        for(int i=1;i<=r+1;i++)
        {
            right=right.next;
        }
        left.next=right;
        return head;
    }
}
