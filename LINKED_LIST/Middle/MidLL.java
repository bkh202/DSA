package LINKED_LIST.Middle;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}

public class MidLL {
    public static Node Mid(Node head){
        Node slow=head;
        Node fast= head;

        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
   public static void main(String[] args) {
    
   } 
}
