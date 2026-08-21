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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode itr = head;
        int len = 0;
        while(itr != null){
            itr = itr.next;
            len++;
        }
        itr = head;
        ListNode[] list = new ListNode[k];
        int i =0;
        int n = len/k;
        int x = len%k;
        
        while(x!= 0){
            int count = 0;
            ListNode d = new ListNode(-1);
            ListNode temp = d;
            while(count != n+1){
                temp.next = itr;
                itr = itr.next;
                temp = temp.next;
                count++;
            }
            temp.next = null;
            list[i++] = d.next;
            x--;
        }
        while(itr != null){
            ListNode d = new ListNode(-1);
            ListNode temp = d;
            for(int j = 0;j < n;j++){
            temp.next = itr;
            itr = itr.next;
            temp = temp.next;
            }
            temp.next = null;
            list[i++] = d.next;
        }
        return list;
    }
}