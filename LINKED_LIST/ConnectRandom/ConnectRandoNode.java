package LINKED_LIST.ConnectRandom;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node ramdom;

    Node(int val) {
        this.val = val;
    }
}

public class ConnectRandoNode {
    // brute force
    public static Node GetRandom(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            Node copy = map.get(temp);

            copy.next = map.get(temp.next);
            copy.ramdom = map.get(temp.ramdom);

            temp = temp.next;
        }
        return map.get(head);
    }
    // Optimal

    public static void InsertInBetween(Node head) {
        Node temp = head;

        while (temp != null) {
            Node nextEle = temp.next;
            Node copy = new Node(temp.val);
            copy.next = nextEle;
            temp.next = copy;
            temp = nextEle;
        }
    }

    public static void ConnectRandom(Node head) {
        Node temp = head;

        while (temp != null) {
            Node copyNode = temp.next;

            if (temp.ramdom != null) {
                copyNode.ramdom = temp.ramdom.next;
            } else {
                copyNode.ramdom = null;

            }
            temp = temp.next.next;
        }
    }

    public static Node getDeepCopy(Node head) {
        Node temp = head;

        Node dummy = new Node(-1);

        Node res = dummy;

        while (temp != null) {
            Node copy = temp.next;

            res.next = copy;
            res = copy;

            temp.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            temp = temp.next;
        }

        return dummy.next;
    }

    public static Node Random(Node head) {
        if (head == null)
            return null;

        InsertInBetween(head);

        ConnectRandom(head);

        return getDeepCopy(head);
    }

    public static void main(String[] args) {

    }
}
