import linkedList.createNode
import linkedList.reverseNode

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    val head = createNode(array)
    println(head)
    val reverseNode = reverseNode(head)
    println(reverseNode)
}
