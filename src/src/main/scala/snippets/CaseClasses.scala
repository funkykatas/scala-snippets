package src.main.scala.snippets

object CaseClasses {

  case class Person(name: String, surname: String)
  case class MutablePerson(var name: String, var surname: String)
  case class NamedBox(val number: Int, name: String)

  def getGreet(person: Person): String = person match {
    case Person("Marry", "Saint") => s"Holy molly! Hello ${person.name} ${person.surname}!"
    case _ => s"Hi ${person.name}"
  }

  def main(args: Array[String]): Unit = {

    val robert: Person = Person("Robert", "Grindevald")
    val marry = Person("Marry", "Saint")

    println(getGreet(robert))
    println(getGreet(marry))

    //robert.name = "a"
    val agne = MutablePerson("Agne", "Zvikaite")
    agne.name = "Agnė"

    println(agne)

    val box1 = NamedBox(1, "One sword")
    println(box1)
    val box2 = box1.copy(name = "One axe!")
    println(box2)

  }

}
