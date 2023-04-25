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
        if(head.next.next == null){
            if(n==1){
                head.next = null;
                return head;
            }else{
                return head.next;
            }
        } 
        if(head.next.next.next == null){
            if(n==1){
                head.next.next = null;
                return head;
            }else if(n==2){
                head.next = head.next.next;
                return head;
            }else{
                head = head.next;
                return head;
            }
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

        int indexToSearch = size-n;
        int i = 1;
        ListNode prev = head; 
        while(i < indexToSearch){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;

    }
}
