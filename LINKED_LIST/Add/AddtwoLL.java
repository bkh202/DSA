package LINKED_LIST.Add;

import LINKED_LIST.Reverse.Node;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {

    public static Node reverse(Node head) {
        Node prev = null;
        Node temp = head;

        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static Node addTwoListsHelper(Node head1, Node head2) {
        // code here
        Node dummy = new Node(-1);
        Node temp = dummy;

        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {
            int sum = 0;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            sum += carry;
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            temp.next = newNode;
            temp = temp.next;
        }

        return dummy.next;
    }

    public static Node addTwoLists(Node l1, Node l2) {
        Node ans1 = reverse(l1);
        Node ans2 = reverse(l2);

        Node finalAns = addTwoListsHelper(ans1, ans2);

        finalAns = reverse(finalAns);

        while (finalAns != null && finalAns.data == 0 && finalAns.next != null) {
            finalAns = finalAns.next;
        }

        return finalAns;
    }

    public static void main(String[] args) {

    }
}
