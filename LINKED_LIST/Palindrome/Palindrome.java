package LINKED_LIST.Palindrome;

import java.util.Stack;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Palindrome {

    // brute force
    public static boolean palindrome(Node head){
        Node temp= head;
        Stack<Integer> s= new Stack<>();

        while (temp != null) {
            s.push(temp.val);
            temp=temp.next;
        }
        temp=head;

        while (temp != null) {

            if(temp. val != s.pop()){

            if(temp. val != s.peek()){

                return false;
            }else{
                temp=temp.next;
            }
        }
       
    }
     return true;
}

    // optimal using slow and fast and revese method

    public static Node Reverse(Node head){
        Node curr= head;
        Node prev=null;
        while(curr != null){
            Node front= curr.next;
            curr=prev;
            prev=curr;
            curr=front;
        }

        return prev;
    }
    public static boolean PalindromeLL(Node head){
        if ( head == null || head .next == null) return true;

        Node slow =head;
        Node fast= head;
        while (fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        slow.next= Reverse(slow.next);
        slow=slow.next;

        while (slow != null) {
            if(head.val != slow.val){
                return false;
            }
            head=head.next;
            slow=slow.next;
        }
          return true;

    }
    public static void main(String[] args) {
        
    }
}
