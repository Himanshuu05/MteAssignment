class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy head
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    // Helper to print the list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " → " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortedLists m = new MergeSortedLists();

        // List 1: 1 → 3 → 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // List 2: 2 → 4 → 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode merged = m.mergeTwoLists(l1, l2);
        System.out.print("Merged List: ");
        m.printList(merged);
    }
}
