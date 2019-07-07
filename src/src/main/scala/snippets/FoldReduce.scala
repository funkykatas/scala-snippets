package src.main.scala.snippets

object FoldReduce {

  def main(args: Array[String]): Unit = {
    //TODO: array vs list in scala
    reduceSum()
    reduceStrings()
    println(findLongestString(List("a", "aa", "aaa")))
    println(s"Reduce right subtract: ${reduceRightSubtract(List(1, 2, 3, 4))}")
    println(s"Reduce left subtract: ${reduceLeftSubtract(List(1, 2, 3, 4))}")
    foldLeftSum(List(1, 2, 3, 4))
    scanLeftExample(List(1, 2, 3))
  }

  //applies to previous sum and current value. Map applies to current values only.
  def scanLeftExample(ints: List[Int]): Unit = println(ints.scanLeft(10)(_ + _)) //10, 11, 13, 16

  def foldLeftSum(ints: List[Int]): Unit = println(ints.foldLeft(10)(_ + _))

  def reduceRightSubtract(ints: List[Int]): Int = ints.reduceRight(_ - _) // first receives 3 and 4, not 4 and 3

  def reduceLeftSubtract(ints: List[Int]): Int = ints.reduceLeft(_ - _)

  def findLongestString(strings: List[String]): String = {
    strings.reduce(longest)
  }

  def longest(s1: String, s2: String): String = if (s1.length > s2.length) s1 else s2

  def reduceSum(): Unit = println(List(1, 2, 3, 4).reduce(_ + _))

  def reduceStrings(): Unit = {
    val data = List("A", "B", "C")

    // go forward list, from left to right most element:
    println(s"Reduce left: ${data.reduceLeft(_ + _)}") //A + B, AB + C => ABC

    // go backward list, from right to left most element
    println(s"Reduce right: ${data.reduceRight(_ + _)}") // B + C, A + BC => ABC
  }

}
