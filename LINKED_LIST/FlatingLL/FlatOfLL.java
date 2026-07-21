package LINKED_LIST.FlatingLL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Node{
    int val;
    Node next;
    Node child;

    Node(int val){
        this.val=val;
    }

    Node( int val, Node child, Node next){
        this.val=val;
        this.next=null;
        this.child=null;
    }

}

public class FlatOfLL {
    // brute force
   public static Node convertArrTOLL(ArrayList<Integer> arr){
         Node dummy= new Node(-1);
         Node temp=dummy;
         for(int data : arr){
            temp.child= new Node(data);
            temp=temp.child;
         }
         return dummy.child;
   }

   public static Node Flating(Node head){
       ArrayList<Integer> arr= new ArrayList<>();
        while(head != null){
            Node h2= head;
            while(h2 != null){
                arr.add(h2.val);
                h2=h2.child;

            }
            head=head.next;
        }
        Collections.sort(arr);

        return convertArrTOLL(arr);
   }
    public static void main(String[] args) {
        
    }
}
