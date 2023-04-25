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
    public ListNode deleteMiddle(ListNode head) {
        //agar 1 hai to empty kr do
        if(head.next == null){
            return null;
        }
        //agar 2 hai to 2nd ko delete kr do
        if(head.next.next == null){
            head.next = null;
            return head;
        }
        if(head.next.next.next == null){
            head.next = head.next.next;
            return head;
        }
        ListNode r = head;
        ListNode c = head;
        ListNode m = head;
        while(r.next!=null && r.next.next!=null){
            r = r.next.next;
            c = c.next;
        }
        if(r.next == null){
            m = c;
        }else{
            m = c.next;
        }
        
        c = head;
        while(c.next != m){
            c = c.next;
        }
        c.next = c.next.next;
        return head;

        
    }
}
