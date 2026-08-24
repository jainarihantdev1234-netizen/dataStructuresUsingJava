/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node deepCopy(Node head){
    Node head2 = new Node(head.val);

        Node t1 = head.next;
        
        Node t2 = head2;

        while(t1 != null){
            
        
            Node temp = new Node(t1.val);
            t2.next = temp;
            t1 = t1.next;
            t2 = t2.next;
        
            
        }
        t2.next = null;
        return head2;
}
public void joinAlternatively(Node head,Node head2){
    Node temp = new Node(-1);
    Node itr = temp;
    Node itr1 = head;
    Node itr2 = head2;
    while(itr1 != null && itr2  != null){

        itr.next = itr1;
        itr1 = itr1.next;
        itr = itr.next;
        itr.next = itr2;
        itr = itr.next;        
        itr2 = itr2.next;
    }
    itr.next = null;
    return;
}
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node head2 = deepCopy(head);
        joinAlternatively(head,head2);
        Node t1 = head;
        
        while(t1 != null){
            
            if(t1.random != null){
                t1.next.random = t1.random.next;
            }
           
            t1 = t1.next.next;
        }
        Node temp1 = new Node(-1);
        Node dot = temp1;
        Node itr3 = head;
        
        while(itr3 != null){
            temp1.next = itr3.next;
            temp1 = temp1.next;
            
                itr3.next = temp1.next;
            
            
            itr3 = itr3.next;
        }
        


        return dot.next;


    }
}