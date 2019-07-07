package src.main.scala.snippets

object Types {

  // Some nasty type alias action
  type WTF = Map[String, List[Map[String, Int]]]

  def findStuff(): WTF = {
    Map("Oh boy" -> List(Map("j" -> 1)))
  }

  def main(args: Array[String]): Unit = {
    val dafuq: WTF = findStuff()
    println(dafuq)
  }

}
