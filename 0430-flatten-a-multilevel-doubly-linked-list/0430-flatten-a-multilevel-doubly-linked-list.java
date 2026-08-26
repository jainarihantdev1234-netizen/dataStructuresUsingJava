/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
public Node update(Node temp){
    // if(temp == null){
    //     return temp;
    // }
    // if(temp.next == null){
    //     if(temp.child != null){
    //         temp.next = temp.child;
    //         temp.child.prev = temp;
    //         temp.child = null;
    //         return update(temp.next);
    //     }
    // }
    // Node temp2 = temp;
    // while(temp != null && temp.next != null){
    //     if(temp.child != null){
    //         temp2 = temp.next;
    //         temp.next = temp.child;
    //         temp.child.prev = temp;
    //         temp.child = null;
    //         Node temp1 = update(temp.next);
    //         temp1.next = temp2;
    //         temp2.prev = temp1;
    //         temp = temp2;
    //     }
    //     else{
    //         temp = temp.next;
    //     }
    // }
    // if(temp != null && temp.child != null){
    //     return update(temp);
    // }
    // return temp;
    if(temp == null){
        return temp;
    }
    
    Node temp2 = temp;
    while(temp != null && temp.next != null){
        if(temp.child != null){
            temp2 = temp.next;
            temp.next = temp.child;
            temp.child.prev = temp;
            temp.child = null;
            Node temp1 = update(temp.next);
            temp1.next = temp2;
            temp2.prev = temp1;
            temp = temp2;
        }
        else{
            temp = temp.next;
        }
    }
    if(temp.next == null){
        if(temp.child != null){
            temp.next = temp.child;
            temp.child.prev = temp;
            temp.child = null;
            return update(temp.next);
        }
    }
    return temp;
    
    

}
    public Node flatten(Node head){
        Node tail = update(head);
        return head;
    }
}