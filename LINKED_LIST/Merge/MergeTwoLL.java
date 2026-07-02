package LINKED_LIST.Merge;

import java.util.ArrayList;

import java.util.Collections;



class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeTwoLL {
    // brute force
    public static Node Converting(ArrayList<Integer> arr) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        for (int i = 0; i < arr.size(); i++) {
            temp.next = new Node(arr.get(i));
            temp = temp.next;
        }
        return dummyNode.next;
    }

    public static Node merge(Node l1, Node l2) {
        ArrayList<Integer> list = new ArrayList<>();
        Node temp1 = l1;
        Node temp2 = l2;
        while (temp1 != null) {
            list.add(temp1.val);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            list.add(temp2.val);
            temp2 = temp2.next;
        }

        Collections.sort(list);

        Node head = Converting(list);
        return head;
    }
  // optimal
    public static Node Merge(Node l1, Node l2) {
        Node dummpyNode = new Node(-1);
        Node temp = dummpyNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
            l1 = l1.next;
        } else {
            temp.next = l2;
        }
        return dummpyNode.next;
    }

    public static void main(String[] args) {

    }
}
