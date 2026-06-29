package LINKED_LIST;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class DeleteNodeFromX {
    public static Node Delete(Node head, int x) {
        Node dummy = new Node(x, head);
        Node slow = dummy;
        Node fast = dummy;

        for (int i = 0; i < x; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
