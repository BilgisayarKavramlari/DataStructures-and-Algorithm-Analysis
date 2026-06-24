public class LinkedListExample {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // A linked list stores nodes connected by references.
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);

        ListNode current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
