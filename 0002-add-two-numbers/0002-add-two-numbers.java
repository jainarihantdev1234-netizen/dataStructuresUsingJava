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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode itr1 = l1;
        ListNode itr2 = l2;
        int sum = 0;
        int carry = 0;
        ListNode temp = new ListNode(-1);
        ListNode per = temp;
        while(itr1 != null && itr2 != null){
            sum = itr1.val + itr2.val + carry;
            carry = sum/10;
            ListNode x = new ListNode(sum%10);
            temp.next = x;
            temp = temp.next;
            itr1 = itr1.next;
            itr2 = itr2.next;

        }
        while(itr1 != null || itr2  != null){
            if(itr1 != null){
                sum = itr1.val + carry;
            carry = sum/10;
            ListNode x = new ListNode(sum%10);
            temp.next = x;
            temp = temp.next;
            itr1 = itr1.next;
            }
            else{
                sum = itr2.val + carry;
            carry = sum/10;
            ListNode x = new ListNode(sum%10);
            temp.next = x;
            temp = temp.next;
            itr2 = itr2.next;
            }
        }
        if(carry != 0){
            ListNode x = new ListNode(carry);
            temp.next = x;
            temp = temp.next;
        }

        temp.next = null;




        return per.next;
    }
}