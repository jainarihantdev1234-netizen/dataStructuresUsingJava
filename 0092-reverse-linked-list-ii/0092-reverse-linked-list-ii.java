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
      public void reverse(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode pre = null;
        
        ListNode in = head;
        ListNode post = head.next;
        while(post != null){
            in.next = pre;
            pre = in;
            in = post;
            post = post.next;
        }
        in.next = pre;
        return;
      }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode a = null;
        ListNode d = null;
        ListNode b = head;
        ListNode c = head;
        ListNode temp = head;
        int pos = 1;
        while(temp.next != null){
            if(pos + 1 == left){
                a = temp;
                b = temp.next;
            }
            if(pos == right){
                d = temp.next;
                c = temp;
            }
            temp = temp.next;
            pos++;
        }
        if(1 == left) b = head;
        if(pos == right) c = temp;
        if(b == c) return head;
        
        c.next = null;
        reverse(b);
        if(a == null && d == null) return c;
        if( a == null){
            b.next = d;
            return c;
        }
        a.next = c;
        b.next = d;
        return head;

 
 
    }
}