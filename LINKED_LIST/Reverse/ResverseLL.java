package LINKED_LIST.Reverse;

import java.util.Stack;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}

public class ResverseLL {

    // brute force
    public static Node Reverse(Node head){
        Stack<Integer> st= new Stack<>();

        Node temp= head;

        while (temp != null) {
            st.push(temp.val);
            temp=temp.next;
        }

        temp=head;

        while (!st.isEmpty()) {
            temp.val= st.pop();
            temp=temp.next;
        }
        return head;

    }
  // optimal
    public static Node reverseNode(Node head){
        Node temp=head;
        Node prev= null;

        while (temp != null) {
            Node front= temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public static void main(String[] args) {
        Node node= new Node(1);
        
    }
}
