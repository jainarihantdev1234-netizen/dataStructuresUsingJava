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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        ListNode in = slow.next;
        ListNode post = slow.next.next;
        while(post != null){
            in.next = pre;
            pre = in;
            in = post;
            post = post.next;
        }
        in.next = pre;
        slow.next = null;
        slow = head;
        fast = in;
        boolean flag = true;
        while(slow != null && fast != null ){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;

    }
}