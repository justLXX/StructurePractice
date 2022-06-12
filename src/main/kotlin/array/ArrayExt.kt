package array


fun IntArray.print() {
    print("[")
    this.forEachIndexed { index, it ->
        if (index < size - 1)
            print("$it,")
        else
            print("$it]")
    }
}


val ARRAY_CASE1 = intArrayOf(3, 2, 4, 6, 5, 7, 8, 1)