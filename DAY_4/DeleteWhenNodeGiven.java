package DAY_4;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}

public class DeleteWhenNodeGiven {
    public static void deleteNode(ListNode node) {
        node.data = node.next.data;
        ListNode tmp = node.next;
        node.next = node.next.next;
        tmp.next = null;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        printList(head);
        deleteNode(head.next.next);
        System.out.println("After deletion:");
        printList(head);
    }
}
