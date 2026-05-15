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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode temp = head;
        ListNode prev = null;

        while(temp!=null){
            ListNode kthNode = findk(temp,k);
            if(kthNode==null){
                if(prev!=null) {
                    prev.next = temp;
                    break;
                }else{
                    return head;
                }

            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            ListNode newHead = reverse(temp);
            if(prev ==null) {
                head = newHead;
            }else{
                prev.next = newHead;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;

    }


    public ListNode reverse(ListNode temp) {
        ListNode prev = null;
        ListNode curr = temp;
        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }

    public ListNode findk(ListNode temp, int k) {
        k--;

        while(temp!=null && k>0) {
            k--;
            temp=temp.next;
        }
        return temp;
    }
}
//tcO(2n) sc -O(1)


