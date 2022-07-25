package practice.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode lsum = new ListNode();
        if (l1 == null) {
            lsum = l2;
            if (lsum.val >= 10) {
                lsum.val -= 10;
                lsum.next = addTwoNumbers(new ListNode(1), l2.next);
            }
        } else if (l2 == null) {
            lsum = l1;
            if (lsum.val >= 10) {
                lsum.val -= 10;
                lsum.next = addTwoNumbers(new ListNode(1), l1.next);
            }
        } else {
            lsum.val = l1.val + l2.val;
            if (lsum.val >= 10) {
                if (l1.next == null) {
                    l1.next = new ListNode(1);
                } else {
                    l1.next.val++;
                }
                lsum.val -= 10;
            }
            lsum.next = addTwoNumbers(l1.next, l2.next);
        }
        return lsum;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(3);
        ListNode result = obj.addTwoNumbers(l1, l2);
        while (result != null) {
            logger.info("{}", result.val);
            result = result.next;
        }
    }
}