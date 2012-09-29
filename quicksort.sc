object quicksort {
  def partition(vals: Array[Int], left: Int, right: Int, pivotIndex: Int): Int = {
    val pivotVal = vals(pivotIndex)
    vals(pivotIndex) = vals(right)
    vals(right) = pivotVal

    var storeIndex = left

    for (i <- left until right) {
      if (vals(i) < pivotVal) {
        val swap = vals(i)
        vals(i) = vals(storeIndex)
        vals(storeIndex) = swap
        storeIndex += 1
      }
      val swap = vals(storeIndex)
      vals(storeIndex) = vals(right)
      vals(right) = swap
    }

    storeIndex
  }                                               //> partition: (vals: Array[Int], left: Int, right: Int, pivotIndex: Int)Int

  def quicksort(vals: Array[Int], left: Int, right: Int): Array[Int] = {
    if (left < right) {
      val pivotIndex = left + (right - left) / 2
      val pivotNewIndex = partition(vals, left, right, pivotIndex)
      quicksort(vals, left, pivotNewIndex - 1)
      quicksort(vals, pivotNewIndex + 1, right)
    }
    vals
  }                                               //> quicksort: (vals: Array[Int], left: Int, right: Int)Array[Int]

  quicksort(Array(10, 6, 3, 2, 7), 0, 4)          //> res0: Array[Int] = Array(2, 10, 7, 3, 6)
}