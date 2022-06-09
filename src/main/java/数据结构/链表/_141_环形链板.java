package 数据结构.链表;


public class _141_环形链板 {

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode fast = head.next;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                if (fast == slow) return true;
                fast = fast.next.next;
                slow = slow.next;
            }
            return false;
        }

        public boolean hasCycle2(ListNode fast,ListNode slow) {
            if (fast == null || fast.next == null) return false;
            if(fast==slow)return true;
            return hasCycle2(fast.next.next,slow.next);
        }

    }
}

