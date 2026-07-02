package LINKED_LIST.InterSection;

import java.util.HashMap;
import java.util.HashSet;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class InterSectionOfLL {

    // Brute Force

    public static Node InterSection(Node l1, Node l2){
        while(l2 != null){
            Node temp = l1;
            while( temp != null){
                if(temp == l2){
                    return l2;
                }
                temp=temp.next;
            }
             l2=l2.next;
        }
        return null;
    }
   // Better Approach using HashMap

    public static Node Intersection2(Node l1 , Node l2){

        HashSet<Node> hm= new HashSet<>();
        while(l1 != null){
            hm.add(l1);
            l1=l1.next;
        }

        while(l2 != null){
            if(hm.contains(l2)) return l2;
            l2=l2.next;
        }

        return null;
    }

    // optimal
    public static Node Intersection3(Node l1, Node l2){
          Node d1= l1;
          Node d2=l2;

          while(d1 != d2){
            d1=d1==null? l2:d1.next;
            d2= d2== null? l1: d2.next;
          }
          return d1;
    }
    public static void main(String[] args) {
        
    }
}
