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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int lo = 0;
        int hi = n-1;
        int top = 0;
        int down = m-1;
        int count = m*n;
        int c = 0;
        ListNode temp = head;
        int[][] arr = new int[m][n];
        while(c < count){
            for(int i = lo;i <= hi && c<count;i++){
                if(temp == null){
                    arr[top][i] = -1;  
                    c++;  
                }else{
                arr[top][i] = temp.val;
                temp = temp.next;
                c++;
                } 
            }
            top++;
            for(int i = top;i <= down && c<count;i++){
                if(temp == null){
                    arr[i][hi] = -1;  
                    c++;  
                }else{
                arr[i][hi] = temp.val;
                temp = temp.next;
                c++;
                }
            }
            hi--;
            for(int i = hi;i >=lo && c<count;i--){
                if(temp == null){
                    arr[down][i] = -1;  
                    c++;  
                }else{
                arr[down][i] = temp.val;
                temp = temp.next;
                c++;
                }
            }
            down--;
            for(int i = down;i >= top && c<count;i--){
                if(temp == null){
                    arr[i][lo] = -1;  
                    c++;  
                }else{
                arr[i][lo] = temp.val;
                temp = temp.next;
                c++;
                }
            }
            lo++;
            

        }
        return arr;
    }
}