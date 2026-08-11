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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp1 = new ListNode(-1);
        ListNode temp2 = new ListNode(-1);
        ListNode itr1 = temp1;
        ListNode itr2 = temp2;
        ListNode itr = head;
        int indx = 0;
        while(itr != null){
            if(indx%2 == 0){
                itr1.next = itr;
                itr1 = itr1.next;
                indx++;
            }
            else{
                itr2.next = itr;
                itr2 = itr2.next;
                indx++;
            }
            itr = itr.next;
        }
        itr1.next = temp2.next;
        itr2.next = null;

        return temp1.next;
    }
}