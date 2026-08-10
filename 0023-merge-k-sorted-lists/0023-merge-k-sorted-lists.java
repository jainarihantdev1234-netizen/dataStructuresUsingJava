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
     ListNode merge(ListNode temp1,ListNode temp2){
        if(temp1 == null && temp2 == null)return null;
      ListNode t  = new ListNode(-1);
        ListNode d = t;
        ListNode t1 = temp1;
        ListNode t2 = temp2;
        
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
            t.next = t2;
        }
        else{
            t.next = t1;
        }
        return d.next;
    
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode tead = lists[0];
        for(int i = 1;i < lists.length;i++){
            tead = merge(tead,lists[i]);
        }
        return tead;
    }
}