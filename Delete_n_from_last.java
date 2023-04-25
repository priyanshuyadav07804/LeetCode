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
        
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        if(n == size){
            head = head.next;
            return head;
        }
        if(n == size-1){
            head.next = head.next.next;
            return head;
        }
        if(n == size-2){
            head.next.next = head.next.next.next;
            return head;
        }

        int indexToSearch = size-n+1;
        int i = 1;
        ListNode prev = head; 
        while(i < indexToSearch-1){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;

    }
}
