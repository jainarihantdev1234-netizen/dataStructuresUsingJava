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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode t  = new ListNode(-1);
        ListNode d = t;
        ListNode t1 = list1;
        ListNode t2 = list2;
        if(t1 == null && t2 == null){
            return null;
        }
        if(t1 == null ){
            return t2;
        }
        else if(t2 == null){
            return t1;
        }
        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                t.next = t1;
                t1 = t1.next;
                t = t.next;
            }
            else{
                t.next = t2;
                t2 = t2.next;
                t = t.next;
            }
        }

        
        if(t1 == null){
            while(t2 != null){
                t.next = t2;
                t2 = t2.next;
                t = t.next;
            }
        }
        else{
            while(t1 != null){
                t.next = t1;
                t1 = t1.next;
                t = t.next;
            }
        }
        return d.next;
    }
}