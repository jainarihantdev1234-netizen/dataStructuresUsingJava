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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        if(head == null || head.next == null || head.next.next == null){
            return arr;
        }
        ListNode pre = head;
        ListNode inn = head.next;
        ListNode post = head.next.next;
        int first = -1;
        int last = -1;
        int idx = 1;
        int minDistance = -1;
        int maxDistance = -1;
        while(post != null){
            if((inn.val>pre.val && inn.val>post.val) || (inn.val<pre.val && inn.val<post.val)){
                if(first == -1) first = idx;
                if(last != -1){
                    if(minDistance > (idx-last) || minDistance == -1){
                        minDistance = idx-last;
                    }
                }
                last = idx;
            }
                pre = pre.next;
                inn = inn.next;
                post = post.next;
                idx++;
           
        }
        maxDistance = last-first;
        if(first == last) return arr;
        arr[0] = minDistance;
        arr[1] = maxDistance;
        
        return arr;
    }
}