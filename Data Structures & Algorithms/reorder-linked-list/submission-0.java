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
    public void reorderList(ListNode head) {
    
        ListNode mid = findMid(head);

        ListNode second = reverse(mid.next);
        mid.next =null;

        ListNode first = head;

        while(second!=null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            first = temp1;

            second.next = first;
            second =temp2;
        }


        
    }

    public ListNode reverse(ListNode mid) {
        ListNode prev = null;
        ListNode curr = mid;

        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast =fast.next.next;
        }
        return slow;
    }
}
