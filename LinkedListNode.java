// information about the class Node

class LinkedListNode {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static int getNthFromLast(Node head, int n) {
        if (head == null) {
            return -1; // empty linked list, solution can't be possible
        }
        Node start = head;

        // First react at nth node from the start
        while (n > 0 && start != null) {
            start = start.next;
            n--;
        }

        if (n > 0) {
            return -1; // size of linked list is smaller than the given n, solution can't be posssible
        } else if (start == null) {
            /*
             * if size of linked list is equal to the given n, then head node's data will be
             * the answer
             */
            return head.data;
        } else {
            /*
             * Increment both pointer which are at nth distance to each other till we finish
             * the list
             */
            Node ktPointer = start;
            start = head;
            while (ktPointer != null) {
                ktPointer = ktPointer.next;
                start = start.next;
            }
        }
        return start.data;
    }
}
