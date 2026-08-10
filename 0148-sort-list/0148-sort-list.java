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
    public ListNode merge(ListNode temp1,ListNode temp2){
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
        temp1 = d.next;
        return temp1;
    }
    public ListNode sort(ListNode temp1,int size){
        if(temp1.next == null) return temp1;
        ListNode ullu1 = temp1;
        ListNode temp2 = temp1;
        int c1 = size/2;
        int c2 = size-c1;
        for(int i = 1;i < c1;i++){
            ullu1 = ullu1.next;
            temp2 = temp2.next;
        }
        temp2 = temp2.next;
        ullu1.next = null;

        temp1 = sort(temp1,c1);
        temp2 = sort(temp2,c2);
        return merge(temp1,temp2);   
    }
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return sort(head,size);
        
    }
}