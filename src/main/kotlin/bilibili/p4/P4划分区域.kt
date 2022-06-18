package bilibili.p4

import array.print
import array.swap
import kotlin.math.max


fun main() {
    val array = intArrayOf(3, 5, 6, 3, 4, 5, 2, 6, 9, 0)
    print("数组为：")
    array.print()
//    val result = getMax(array, 0, array.size - 1)
//    println("最大值 = $result")

//    mergeSoft(array, 0, array.size - 1)


    flagQuestion2(array, 4)
//
//    flagQuestionRecursion(array, 4, 0, array.size - 1)

    print("最终排序结果：")
    array.print()
}

/**
 * 设置两个指针 pre 和 end 分别代表小于等于区 和大于区
 * pre = 0; end = aar.size-1
 *
 * 当 pre==end 时循环结束
 *
 * 当 aar[pre] <= target pre++
 * 否则 交换 pre和end位置的值 end--
 *
 */
fun flagQuestion(array: IntArray, target: Int) {
    var pre = 0
    var end = array.size - 1

    while (pre != end) {
        if (array[pre] <= target) {
            pre++
        } else {
            array.swap(pre, end)
            end--
        }
    }
}

/// 上面方案的递归写法
fun flagQuestionRecursion(array: IntArray, target: Int, pre: Int, end: Int) {
    if (pre == end) {
        return
    }
    var preVar = pre
    var endVar = end
    if (array[pre] <= target) {
        preVar++
        flagQuestionRecursion(array, target, preVar, endVar)
    } else {
        array.swap(pre, end)
        endVar--
        flagQuestionRecursion(array, target, preVar, endVar)
    }
}


/**
 *  设置连个指针
 *  pre 表示小于目标值的边界
 *  current 表示当前指针位置
 *
 *  当 arr[current]<=target 交换当前位置的数小于区域+1位置的数。
 *  然后 小于区域向右扩即  pre++, current++
 *
 *  否则直接current++
 *
 *  当遍历完数组时循环结束
 */

fun flagQuestion1(array: IntArray, target: Int) {
    var pre = -1
    var current = 0;

    while (current < array.size) {
        if (array[current] <= target) {
            pre++
            array.swap(pre, current++)
        } else {
            current++
        }
    }
}


/**
 * 将数组划分成3个区域 < = >
 * 视频中的思路
 */
fun flagQuestion2(array: IntArray, target: Int) {
    var pre = -1
    var end = array.size
    var current = 0
    while (current < end) {
        if (array[current] < target) {
            array.swap(++pre, current++)
        } else if (array[current] == target) {
            current++
        } else {
            array.swap(--end, current)
        }
    }

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


