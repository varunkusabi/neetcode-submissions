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
    ListNode rev(ListNode mid)
    {
        if(mid==null || mid.next==null)
        {
            return mid;
        }
        ListNode newhead=mid;
        if(mid.next!=null)
        {
            newhead=rev(mid.next);
            mid.next.next=mid;
        }
        mid.next=null;
        return newhead;
    }
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode first=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second=rev(slow);
        ListNode temp=first;
        while(second.next!=null)
        {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

    }
}
