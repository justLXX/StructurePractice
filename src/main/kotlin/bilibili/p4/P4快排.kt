package bilibili.p4

import array.print
import array.println
import array.swap


fun main() {
    val array = intArrayOf(3, 5, 6, 3, 4, 5, 2, 6, 9, 0)
    array.println("数组为：")
    quickSoft1(array, 0, array.size - 1)
    array.println("最终排序结果：")
}

/**
 * @param intArray 数组
 * @param l 左边界
 * @param r 右边界
 * 在 数组{l,r} 上做排序
 */
fun quickSoft1(intArray: IntArray, l: Int, r: Int) {
    if (l < r) {
        println("------------------------------------")
        val targetIndex: Int = (Math.random() * (r - l + 1) + l).toInt()
        println("targetIndex = $targetIndex")
        println("l = $l  r = $r  targetValue = ${intArray[targetIndex]}")
        intArray.swap(targetIndex, r)

        intArray.println("交换后的array")

        val array = partition(intArray, l, r)

        intArray.println("分组后的array")

        array.println("目标值边界")

        quickSoft1(intArray, l, array[0] - 1)

        quickSoft1(intArray, array[1] + 1, r)
    }
}

/**
 *  以数组最右侧的值作为划分值
 */
fun partition(array: IntArray, l: Int, r: Int): IntArray {
    var less = l - 1  // < 边界
    var more = r    // > 边界
    var current = l //当前位置指针
    val target = array[r] // 分割目标值
    while (current < more) {
        if (array[current] < target) {
            array.swap(++less, current++)
        } else if (array[current] > target) {
            array.swap(--more, current)
        } else {
            current++
        }
    }
    array.swap(more, r)
    return intArrayOf(less + 1, more)
}