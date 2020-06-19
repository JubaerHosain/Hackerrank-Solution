/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

static boolean hasCycle(Node head) {
        if(head == null){
            return false;
        }

        Node current = head;
        Node temp = head;
        while(current != null  && current.next != null){
            temp = temp.next;
            current = current.next.next;

            if(current == temp){
                return true;
            }
        }

        return false;
    }
