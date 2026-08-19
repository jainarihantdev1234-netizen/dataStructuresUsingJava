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
    public ListNode reverse(ListNode a){
        if(a == null || a.next == null) return a;
        ListNode pre = null;
        ListNode in = a;
        ListNode post = a.next;
        while(post != null){
            in.next = pre;
            pre = in;
            in = post;
            post = post.next;
        }
        in.next = pre;
        
        return in;

    }
    
    public void reorderList(ListNode head) {
        ListNode mid = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            mid = mid.next;
            fast = fast.next.next;
        }
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        ListNode temp1 = head;
        ListNode temp2 = head2;
        ListNode temp = new ListNode(-1);
        while(temp1 != null && temp2 != null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;
            temp.next = temp2;
            temp = temp.next;
            temp2 = temp2.next;
        }
        if(temp1 == null && temp2 != null){
            temp.next = temp2;
        }
        if(temp2 == null && temp1 != null){
            temp.next = temp1;
        }

        return;

    }
}