

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int cnt1 = 0, cnt2 = 0;
        SinglyLinkedListNode h1 = head1;
        SinglyLinkedListNode h2 = head2;

        while(h1 != null){
            h1 = h1.next;
            cnt1++;
        }
        while(h2 != null){
            h2 = h2.next;
            cnt2++;
        }

        while(cnt1 > cnt2){
            head1 = head1.next;
            cnt1--;
        }
        while(cnt2 > cnt1){
            head2 = head2.next;
            cnt2--;
        }

        while(head1 != null){
            if(head1 == head2){
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return -1;
    }

