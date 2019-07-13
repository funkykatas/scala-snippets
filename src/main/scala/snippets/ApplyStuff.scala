package main.scala.snippets

object ApplyStuff {

  case class StuffPrinter(prefix: String) {
    def apply(stuff: String): Unit = println(prefix + stuff)
  }

  // no val before arg - constructor argument, but not field
  class SimpleClass(arg: String) {}

  class SimpleFieldClass(val arg: String) {}

  class WithoutNew() {

    def apply(): Unit = {
      println("Can`t confuse me")
    }

    def apply(message: String): Unit = {
      println(s"Was ist das: $message")
    }
  }

  object WithoutNew { //companion object

    def apply(): WithoutNew = {
      val result = new WithoutNew()
      println("Returning new instance of WithoutNew")
      result
    }

    def apply(prefix: String): WithoutNew = {
      val result = new WithoutNew()
      println(s"Returning new instance of WithoutNew with overloaded apply. Message: $prefix")
      result
    }
  }

  class BetterBoolean

  def main(args: Array[String]): Unit = {
    val pr = StuffPrinter("Um, Oh... ")

    // Special syntax that apply method allows.
    // Object pr may be used like a function
    pr("Hello")
    pr("My dear friends")

    WithoutNew() // Instance without "new" keyword
    WithoutNew("Some things will never change")

    WithoutNew()() // Create instance with apply, then use class (not companion (singleton) object) apply method
    WithoutNew()("Wrote something")

    new SimpleClass("a") // Cant access arg

    new SimpleFieldClass("b").arg // Can access arg as its a field now.
  }

}
