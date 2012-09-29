object quicksort {
  def swap(vals: Array[Int], left: Int, right: Int) = {
    val tmp = vals(left)
    vals(left) = vals(right)
    vals(right) = tmp
  }

  def partition(vals: Array[Int], low: Int, high: Int): Int = {
    var pivotItem = vals(low)
    var pivot, left = low
    var right = high

    while (left < right) {
      while (vals(left) <= pivotItem && left < high) left += 1
      while (vals(right) > pivotItem && right >= low) right -= 1
      if (left < right) swap(vals, left, right)
    }

    vals(low) = vals(right)
    vals(right) = pivotItem
    right
  }

  def quicksort(vals: Array[Int], low: Int, high: Int): Array[Int] = {
    if (low < high) {
      val pivotIndex = partition(vals, low, high)
      quicksort(vals, low, pivotIndex - 1)
      quicksort(vals, pivotIndex + 1, high)
    }
    vals
  }
  
  val vals = Array(10, 6, 3, 2, 7, 6, 1, 17, 91, 67, 16)
  quicksort(vals, 0, vals.size - 1)
}