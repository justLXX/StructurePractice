package array


fun IntArray.print(content: String = "") {
    kotlin.io.print("$content[")
    this.forEachIndexed { index, it ->
        if (index < size - 1)
            kotlin.io.print("$it,")
        else
            kotlin.io.print("$it]")
    }
}

fun IntArray.println(content: String = "") {
    this.print(content)
    kotlin.io.println()
}


val ARRAY_CASE1 = intArrayOf(3, 2, 4, 6, 4, 5, 7, 8, 1)


fun swap(array: IntArray, index1: Int, index2: Int) {
    if (index1 == index2) return
    var temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}