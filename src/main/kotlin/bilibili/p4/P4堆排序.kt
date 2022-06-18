package bilibili.p4

import array.swap


class Heap(capacity: Int) {
    private val a: IntArray ///数组，从下标1开始存储数据
    private var count: Int = 0 // 堆中当前元素个数
    private val max: Int  // 堆中存储最大数据个数

    init {
        max = capacity
        count = 0
        a = IntArray(capacity + 1)
    }

    fun insert(value: Int) {
        if (count >= max) return /// 堆满了
        ++count
        a[count] = value

        var i = count

        while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下往上堆化
            swap(a, i, i / 2)
            i /= 2
        }
    }
}