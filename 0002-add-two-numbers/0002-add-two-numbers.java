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
        while(itr1 != null || itr2 != null){
            int num1 = 0;
            int num2 = 0;
            if(itr1 != null)num1 = itr1.val;
            if(itr2 != null)num2 = itr2.val;
            sum = num1 + num2 + carry;
            carry = sum/10;
            ListNode x = new ListNode(sum%10);
            temp.next = x;
            temp = temp.next;
            if(itr1 != null) itr1 = itr1.next;
            if(itr2 != null) itr2 = itr2.next;

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