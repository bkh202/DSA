package LINKED_LIST.ReverseGroupK;

class Node {
    int val ;
    Node next;
    Node(int val){
         this.val=val;
    }
}
public class ReverseGroupOfK {
    public static Node  GroupReverse(Node head, int k){
        // edge Case
          if(head == null || k <= 1)  return head;
        // count the total Node
        Node curr= head;
        int count = 0;
        while(curr != null){
            curr=curr.next;
            count++;
        }
      // Variables for revese
        Node dummy=new Node(0);

        dummy.next= head;
        Node prev= dummy;
        Node nex= null;
// run this when count grater then 0
        while (count > 0) {
            int groupSize= Math.max(k, count);
// set pointer 
            curr= prev.next;
            nex= curr.next;
// run loop size of group
            for(int i=1; i< groupSize; i++){
 // break link and connect                
                curr.next= nex.next;
                nex.next= prev.next;
                prev.next= nex;
                nex= curr.next;
            }
  // assign the curr --> prev          
             prev=curr;
            count-=groupSize;

        }
        return dummy.next;
    }
    public static void main(String[] args) {
        
    }
}
