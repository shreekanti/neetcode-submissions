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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode h1 = list1;
        ListNode h2 = list2;
        
        
        while(h1!=null && h2!=null) {
            if(h1.val<=h2.val) {
                curr.next =h1;
                curr = h1;
                h1=h1.next;
            }else{
                curr.next=h2;
                curr=h2;
                h2=h2.next;
            }
        }

        if(h1!=null) {
            curr.next =h1;
        }else{
            curr.next=h2;
        }

        return dummy.next;
    }
}