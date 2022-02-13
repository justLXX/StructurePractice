package linkedList

import java.util.*

data class ListNode(val `val`: Int, var next: ListNode? = null) {

    override fun toString(): String {
        var str = `val`.toString()
        var nextNode = next;
        while (nextNode != null) {
            str += nextNode.`val`
            nextNode = nextNode.next
        }
        return str
    }
}


fun createNode(array: IntArray): ListNode {
    val head = ListNode(0)///哨兵
    var currentNode = head;
    array.forEach {
        val node = ListNode(it)
        currentNode.next = node
        currentNode = node;
    }
    return head.next!!
}


fun reverseNode(head: ListNode): ListNode {
    if (head.next == null) return head
//    return reverseListByStack(head)
//    return reverseListByIteration(head)
    return reverseListByRecursive(head)!!
}


fun reverseListByStack(head: ListNode): ListNode {
    val stack = Stack<ListNode>()
    var currentNode: ListNode? = head;
    stack.push(currentNode)
    while (currentNode?.next != null) {
        currentNode = currentNode.next;
        stack.push(currentNode)
    }
    println(stack)
    var reverseNode = ListNode(0)
    var temp = reverseNode
    while (!stack.isEmpty()) {
        temp.next = stack.pop()
        temp = temp.next!!
    }
    temp.next = null
    return reverseNode.next!!
}

//
//
//
//
//
//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
/**
 * 迭代
 *
 * 假设链表为 1→2→3→∅，我们想要把它改成 ∅←1←2←3。
 * 在遍历链表时，将当前节点的 `next` 指针改为指向前一个节点。
 * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
 * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
 *
 * 复杂度分析
 * 时间复杂度：O(n)O(n)，其中 nn 是链表的长度。需要遍历链表一次。
 * 空间复杂度：O(1)O(1)。
 */
fun reverseListByIteration(head: ListNode): ListNode {
    var prev: ListNode? = null
    var current: ListNode? = head
    while (current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev!!
}


/**
 *
 * 递归方式翻转链表
 * 参考 [https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/]
 *
 * Demo
 *
 * reverseList: head=1
 *      reverseList: head=2
 *          reverseList: head=3
 *              reverseList:head=4
 *                  reverseList:head=5
 *                              终止返回
 *                      cur = 5
 *                      4.next.next->4，即5->4
 *                  cur=5
 *                  3.next.next->3，即4->3
 *          cur = 5
 *          2.next.next->2，即3->2
 *  cur = 5
 *  1.next.next->1，即2->1
 *  最后返回cur
 *
 *  时间复杂度：O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
 *  空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
 *
 *
 *  *********************** 递归解释******************
 *  1. 结束条件
 *  2. 递过程 （递归调用前面代码）
 *  3. 递归调用
 *  4. 归过程 （递归调用后面代码）
 */
fun reverseListByRecursive(head: ListNode?): ListNode? {
    // 递归终止条件
    if (head?.next == null) {
        return head;
    }
    val newHead: ListNode? = reverseListByRecursive(head.next);
    /// 归过程 （交换指针）
    head.next?.next = head;
    head.next = null//避免形成环
    return newHead
}