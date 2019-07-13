package main.scala.snippets

object LazyCodes {

  def main(args: Array[String]): Unit = {
    lazyParamFunction(getNum())
    lazyFixed(getNum())
    matchList(List(1, 2))
    concatList(List(1, 2))
    concatList(Nil)
    matchGuard(1, List(1, 2))
    matchGuard(1, List(2, 2))
    foldRightTest()
    println(funkyList())
    funkyMatchList(List(1, 2, 3))
    println(s"Sum: ${listSum(List(1, 2, 3, 4))}")
  }

  def listSum(ints: List[Int]): Int = ints match {
    case h :: t => h + listSum(t)
    case Nil => 0
  }

  def foldRightTest(): Unit = {
    //List(1, 2, 3, 4).foldRight()
  }

  def funkyMatchList(ints: List[Int]): Unit = ints match {
    case head :: tail => println(s"Yep, its a list with head $head and tail $tail")
  }

  def funkyList(): List[Int] = 1 :: 2 :: 3 :: Nil

  def matchGuard(i: Int, ints: List[Int]): Unit = ints match {
    case List(1, 2) if i == 1 => println("i is one")
    case _ => println("Bad list value")
  }

  def concatList(ints: List[Int]): Unit = ints match {
    case Nil => println(List(3))
    case _ => println(3 :: ints)
  }

  def matchList(ints: List[Int]): Unit = ints match {
    case Nil => println("Empty")
    case _ => println(s"Head: ${ints.head}")
  }

  def getNum(): Int = {
    val num = 2
    println(s"Generated: $num")
    num
  }

  def lazyParamFunction(i: => Int): Unit = i + i

  def lazyFixed(num: => Int): Unit = {
    lazy val cachedNum = num
    cachedNum + cachedNum
  }

}
