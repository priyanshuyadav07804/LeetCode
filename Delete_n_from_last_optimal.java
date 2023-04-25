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
        if(head.next == null){
            return null;
        }
        
        ListNode r = head;
        ListNode c = head;

        int i = 0;
        while(i!=n){
            r = r.next;
            i++;
        }
        if(r == null){
            head = head.next;
            return head;
        }
        while(r.next != null){
            r = r.next;
            c = c.next;
        }
        c.next = c.next.next;
        return head;
    }
}
