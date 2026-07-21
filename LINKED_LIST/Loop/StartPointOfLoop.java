package LINKED_LIST.LoopDection;

import java.util.HashMap;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

}

public class StartPointOfLoop {

    // Brute force
    public static Node startPointOfLoop(Node head) {
        HashMap<Node, Integer> m = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            if (m.containsKey(temp)) {
                return temp;
            }
            m.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }
  // Optimize Approach
    public static Node startPointOfLoopOptimize(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head;
        Node entry = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
