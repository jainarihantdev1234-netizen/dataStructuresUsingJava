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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode temp = head;
        
        ListNode in = head;
        ListNode post = head.next;
        while(post != null){
            in.next = pre;
            pre = in;
            in = post;
            post = post.next;
        }
        in.next = pre;
        return in;
    }
}