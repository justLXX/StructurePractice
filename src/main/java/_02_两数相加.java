

/**
 * Definition for singly-linked list.
 */


public class _02_两数相加 {
    public static class ListNode {
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

        @Override
        public String toString() {
            String nextVal = "";
            if (next != null) {
                nextVal = next.toString();
            }
            return "" +
                    "" + val +
                    ", " + nextVal;
        }
    }

    public static void main(String[] args) {
        long[] arr1 = {9};
        long[] arr2 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};

//
        ListNode node = arrayToListNode(arr1);

        System.out.println("result = " + node.toString());
    }

    static ListNode arrayToListNode(long arr[]) {
        ListNode sentinelNode = new ListNode();
        ListNode tempNode = sentinelNode;
        for (long j : arr) {
            ListNode currentNode = new ListNode((int) j);
            tempNode.next = currentNode;
            tempNode = currentNode;
        }
        return sentinelNode.next;
    }



}
