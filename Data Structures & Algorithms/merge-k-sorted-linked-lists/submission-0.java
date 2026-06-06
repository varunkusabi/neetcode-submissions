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
    public ListNode mergetwo(ListNode l1,ListNode l2)
    {
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                temp.next=l1;
                l1=l1.next;
            }
            else
            {
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1!=null)
        {
            temp.next=l1;
        }
        else if(l2!=null)
        {
            temp.next=l2;
        }

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] k) {
        List<ListNode> lists = new ArrayList<>(Arrays.asList(k));
        if (lists.isEmpty()) return null;

        while (lists.size() > 1) {
            ListNode l1 = lists.remove(0);
            ListNode l2 = lists.remove(0);
            ListNode merged = mergetwo(l1, l2);
            lists.add(merged);
        }

        return lists.get(0);
    }
}
