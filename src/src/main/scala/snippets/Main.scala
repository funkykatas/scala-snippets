package src.main.scala.snippets

object Main {

  def main(args: Array[String]): Unit = {
    executeCallback(helloPaulius)
    callAFunc(helloMarius)
    helloPaulius(greetByName)
    helloTwoDudes(greetTwo)
    println(doMultipleTimes(_ + 1, 10, 3))
    println(addThreeNumbers(1, 2, 3))
    println(filter(_ > 1, List[Int](1, 2, 3, 4)))
  }

  def filter(f: Int => Boolean, list: List[Int]): List[Int] = {
    for (x <- list if f(x)) yield x
  }

  def executeCallback(callback: () => Unit): Unit = {
    callback()
  }

  def helloPaulius(): Unit = {
    println("Hello Paulius")
  }

  def helloMarius(): Unit = {
    println("Hello Marius")
  }

  def callAFunc(callback: () => Unit): Unit = {
    callback()
  }

  def helloPaulius(f: String => Unit): Unit = {
    f("Paulius")
  }

  def helloTwoDudes(f: (String, String) => Unit): Unit = {
    f("Mantelis", "Rokelis")
  }

  def greetByName(name: String): Unit = {
    println(s"Hello $name")
  }

  def greetTwo(first: String, notFirst: String): Unit = {
    println(s"Hello two dudes: $first and $notFirst")
  }

  def addTwo(a: Int): Int = a + 2

  def doMultipleTimes(whatDo: Int => Int, value: Int, howMany: Int): Int = {
    if (howMany <= 0)
      value
    else
      doMultipleTimes(whatDo, whatDo(value), howMany - 1)
  }

  val addThreeNumbers: (Int, Int, Int) => Int = (a, b, c) => a + b + c
  val concatStrings: (String, String) => String = (a, b) => a.concat(b)

  def addTwoNumbers(a: Int, b: Int): Int = a + b
  val addTwoNumbersVal = (a: Int, b: Int) => a + b
}
