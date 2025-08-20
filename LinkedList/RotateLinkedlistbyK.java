class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode cur = head;
        int len = 1;

        // find length of list
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }

        // connect tail to head (circular list)
        cur.next = head;

        // effective rotation
        k = k % len;
        k = len - k;

        // move cur k steps
        while (k-- > 0) {
            cur = cur.next;
        }

        // new head will be next node
        head = cur.next;
        cur.next = null;

        return head;
    }
}

public class Main {
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        Solution sol = new Solution();
        System.out.print("Original List: ");
        printList(head);

        head = sol.rotateRight(head, k);

        System.out.print("Rotated List by " + k + ": ");
        printList(head);
    }
}
=========================

  Time Complexity (TC):

Finding length → O(n)

Making list circular & breaking at correct point → O(n)

Total → O(n)

Space Complexity (SC):

Only using a few pointers (no extra list/array).

O(1)
