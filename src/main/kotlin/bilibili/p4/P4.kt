package bilibili.p4

import array.ARRAY_CASE1
import array.print
import kotlin.math.max


fun main() {
    val array = ARRAY_CASE1

    val result = getMax(array, 0, array.size - 1)

    println("最大值 = $result")

    mergeSoft(array, 0, array.size - 1)

    print("最终排序结果：")
    array.print()
}

// 求数组aar[L..R]范围上最大值
fun getMax(array: IntArray, l: Int, r: Int): Int {

    if (l == r) return array[l]

    val m = l + ((r - l) shr 1)

    val maxLeft = getMax(array, l, m)

    val maxRight = getMax(array, m + 1, r)

    return max(maxLeft, maxRight)
}


fun mergeSoft(array: IntArray, l: Int, r: Int) {
    if (l == r) return
    val mid = l + ((r - l) shr 1)
    mergeSoft(array, l, mid)
    mergeSoft(array, mid + 1, r)
    array.forEach {
        print("$it ,")
    }
    println()
    merge(array, l, mid, r)
}

/**
 * @param array 经过初步排序之后，数组 `array` 的 [l,m] 和 [m+1,r]
 * 两个区间已经变成有序。
 * 所有这里做的事情是将连个有序的区间合并成一个有序的区间
 * 思路：
 * 创建一个临时数组 help，长度和 array 一样
 * 定义两个指针：p1,p2 分别指向两个区间的索引位置，p1<=m,p2<l
 * 定义一个指针 i 指向help的索引位置
 *
 * 当 比较 p1,p2 位置对应的值并将较小的值赋值到i所指向的位置
 * 并对操作的索引进行 +1
 *
 * 当p1或p2达到最大值的时候，停止循环，并将没完成的一遍剩余部分
 * 添加到对应位置
 */
fun merge(array: IntArray, l: Int, m: Int, r: Int) {

    print("merge 前：")
    array.forEach {
        print("$it ,")
    }
    println()
    val help = IntArray(size = r - l + 1)
    var p1 = l
    var p2 = m + 1
    var i = 0
    println("l = $l  m = $m  r = $r")

    while (p1 <= m && p2 <= r) {
        println("p2 = $p2 p1 = $p1")
        help[i++] = if (array[p1] <= array[p2]) {
            array[p1++]
        } else {
            array[p2++]
        }
    }

    //左边剩余
    while (p1 <= m) {
        println("p1 = $p1")
        help[i++] = array[p1++]
    }

    //右边剩余
    while (p2 <= r) {
        help[i++] = array[p2++]
    }

    help.forEachIndexed { index, it ->
        println("index = $index  i = $it")
        array[l + index] = it
    }


}


