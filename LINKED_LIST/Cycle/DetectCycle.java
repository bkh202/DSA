package LINKED_LIST.Cycle;

import java.util.HashMap;

class Node {
     int val;
     Node next;

     Node(int val){
        this.val=val;
     }
  }
public class DetectCycle {

    // brute force
    public static boolean Cycle(Node head){
        Node temp=head;
        HashMap<Node, Integer> mp= new HashMap<>();

        while ( temp != null) {
            if(mp.containsKey(temp)){
                return true;
            }
            temp=temp.next;
            mp.put(temp,1);
        }

        return false;
    }

    // optimal
    public static boolean Cycle2(Node head){
        if(head == null || head.next == null) return false;

        Node slow= head;
        Node fast= head;
         
        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        
    }
}
