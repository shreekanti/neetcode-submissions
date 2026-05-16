/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        // copy in between
        Node temp = head;
        while(temp!=null) {
            Node copyNode  = new Node(temp.val);

            copyNode.next = temp.next;

            temp.next = copyNode;
            temp = temp.next.next;
        }

        //link random pointer

        Node tempR = head;

        while(tempR!=null) {
            Node copyNode = tempR.next;
            if(tempR.random!=null ){
                copyNode.random = tempR.random.next;
            }else{
                copyNode.random = null;
            }
            
            tempR= tempR.next.next;
        }

        //link next nodes

        Node tempN = head;
        Node dummy = new Node(-1);
        Node res= dummy;

        while(tempN!=null) {
            res.next = tempN.next;
            res = res.next;
            tempN.next = tempN.next.next;
            tempN = tempN.next;
        }

        return dummy.next;

    }
}
