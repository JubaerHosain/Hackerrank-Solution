

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);

        if(head == null){
            return node;
        }
        else if(node.data < head.data){
            head.prev = node;
            node.next = head;

            return node;
        }
        else{
            DoublyLinkedListNode temp = null;
            DoublyLinkedListNode current = head;

            while(current != null && current.data < node.data){
                temp = current;
                current = current.next;
            }

            if(current == null){
                temp.next = node;
                node.prev = temp;
            }
            else{
                temp.next = node;
                current.prev = node;
                node.next = current;
                node.prev = temp;
            }

            return head;
        }

    }

