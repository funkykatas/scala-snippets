package main.scala.snippets

object Generics {

  abstract class Animal {}
  class Dog extends Animal {}
  class Cat extends Animal {}

  def main(args: Array[String]): Unit = {
    val animals: List[Animal] = List(new Dog, new Cat) // List is List[+A]

    case class Box(animal: Animal)
    Box(new Cat)
  }

}
