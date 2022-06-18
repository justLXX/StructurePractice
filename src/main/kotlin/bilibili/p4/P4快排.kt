package bilibili.p4

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
        //随机获取分割点
        val targetIndex: Int = (Math.random() * (r - l + 1) + l).toInt()

        /// 将分割点数字交换到数组最右边（因为下面 `partition` 函数是使用最右侧的位置作为分割点，所以这里做一下交换）
        swap(intArray, targetIndex, r)

        /// 分割，将数组分割为 < = > 数组最右边的值 `intArray[r]` 三部分，并返回分界点数组
        val array = partition(intArray, l, r)
        /// 递归左侧部分
        quickSoft1(intArray, l, array[0] - 1)
        // 递归右侧部分
        quickSoft1(intArray, array[1] + 1, r)
    }
}

/**
 *  以数组最右侧的值作为划分值
 *  将数组划分为3部分
 *  @return 分界点组成的size为2的数组
 */
fun partition(array: IntArray, l: Int, r: Int): IntArray {
    var less = l - 1  // < 边界
    var more = r    // > 边界
    var current = l //当前位置指针
    val target = array[r] // 分割目标值
    while (current < more) {
        if (array[current] < target) {
            swap(array, ++less, current++)
        } else if (array[current] > target) {
            swap(array, --more, current)
        } else {
            current++
        }
    }
    swap(array, more, r)
    return intArrayOf(less + 1, more)
}