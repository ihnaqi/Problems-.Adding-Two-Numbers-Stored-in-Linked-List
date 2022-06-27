import static org.junit.Assert.*;

import org.junit.Test;

public class App {

    protected class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        int getValue() {
            return this.val;
        }
    }

    private ListNode head;

    public boolean isEmpty() {
        return this.head == null;
    }

    public void add(int val) {
        if (this.isEmpty()) {
            this.head = new ListNode(val);
            return;
        }

        ListNode curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        int num = 0;
        if (l2 == null) {
            head = new ListNode(l1.getValue());
            l1 = l1.next;
        } else if (l1 == null) {
            head = new ListNode(l2.getValue());
            l2 = l2.next;
        } else {
            num = l1.getValue() + l2.getValue();

            head = num > 9 ? new ListNode(num % 10) : new ListNode(num);
            num = num / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode curr = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = num + l2.getValue() < 10 ? new ListNode(l2.getValue() + num)
                        : new ListNode((l2.getValue() + num) % 10);
                num = (l2.getValue() + num) / 10;
                curr = curr.next;
                l2 = l2.next;
            } else if (l2 == null) {
                curr.next = (num + l1.getValue()) < 10 ? new ListNode(l1.getValue() + num)
                        : new ListNode((l1.getValue() + num) % 10);
                num = (l1.getValue() + num) / 10;
                curr = curr.next;
                l1 = l1.next;
            } else {

                // num = num > 0 ? (num + l1.val + l2.val) : (l2.val + l1.val);
                num = num + l1.getValue() + l2.getValue();
                if (num > 9) {
                    curr.next = new ListNode(num % 10);
                    num = num / 10;
                    curr = curr.next;
                } else {
                    curr.next = new ListNode(num);
                    curr = curr.next;
                    num = 0;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if (num > 0) {
            curr.next = new ListNode(num);
        }
        return head;

    }

    public ListNode getHead() {
        return this.head;
    }

    @Test
    public void test00() {
        App app = new App();
        int[] arr1 = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
        int[] arr2 = { 5, 6, 4 };
        for (int i : arr1) {
            app.add(i);
        }

        App app2 = new App();
        for (int i : arr2) {
            app2.add(i);
        }
        ListNode l1 = app.getHead();
        ListNode l2 = app2.getHead();

        ListNode result = new App().addTwoNumbers(l1, l2);
        int[] summation = { 6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 1 };

        App expectedResult = new App();
        for (int i : summation) {
            expectedResult.add(i);
        }

        boolean same = true;
        ListNode curr1 = expectedResult.getHead();
        ListNode curr2 = result;
        do {
            if ((curr1 == null & curr2 != null) || (curr2 == null && curr1 != null)) {
                same = false;
                break;
            } else if (curr1.val != curr2.val) {
                same = false;
                break;
            } else {
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        } while (curr1 != null && curr2 != null);

        assertTrue(same);
    }

    @Test
    public void test01() {
        App app = new App();
        int[] arr1 = { 9, 9, 9, 9, 9, 9, 9 };
        int[] arr2 = { 9, 9, 9, 9 };
        for (int i : arr1) {
            app.add(i);
        }

        App app2 = new App();
        for (int i : arr2) {
            app2.add(i);
        }
        ListNode l1 = app.getHead();
        ListNode l2 = app2.getHead();

        ListNode result = new App().addTwoNumbers(l1, l2);
        int[] summation = { 8, 9, 9, 9, 0, 0, 0, 1 };

        App expectedResult = new App();
        for (int i : summation) {
            expectedResult.add(i);
        }

        boolean same = true;
        ListNode curr1 = expectedResult.getHead();
        ListNode curr2 = result;
        do {
            if ((curr1 == null & curr2 != null) || (curr2 == null && curr1 != null)) {
                same = false;
                break;
            } else if (curr1.val != curr2.val) {
                same = false;
                break;
            } else {
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        } while (curr1 != null && curr2 != null);

        assertTrue(same);
    }
}
