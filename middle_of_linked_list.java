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
// For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head.next == null){
            return head;
        }
        if(head.next.next == null || head.next.next.next == null){
            head = head.next;
            return head;
        }
        ListNode r = head;
        ListNode c = head;
        while(r.next!=null && r.next.next!=null){
            r = r.next.next;
            c = c.next;
        }
        if(r.next == null){
            head = c;
        }else{
            head = c.next;
        }
        return head;
    }
}
