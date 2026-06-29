package LINKED_LIST;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class DeleteNode {
      public static void Delete(Node head){
            if(head == null) return ;
              head.val= head.next.val;
              head.next= head.next.next;

      }
    public static void main(String[] args) {
        
    }
}
