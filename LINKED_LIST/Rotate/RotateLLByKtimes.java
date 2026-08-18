package LINKED_LIST.Rotate;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class RotateLLByKtimes {

    // brute force
    public static Node rotateKTimes(Node head, int k) {

        if (head == null || head.next == null)
            return head;

        for (int i = 0; i < k; i++) {

            Node prev = null;
            Node curr = head;

            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = null;
            curr.next = head;
            head = curr;
        }

        return head;
    }

    // Optimal
    public static Node RotateOptimal(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        Node tail = head;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0)
            return head;

        tail.next = head;

        Node curr = head;

        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }

    public static void main(String[] args) {

    }
}
