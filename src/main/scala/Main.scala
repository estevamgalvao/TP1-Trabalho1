import ed_mutaveis.linkedList


object Main {

  def main(args: Array[String]): Unit = {

    var list1 = new linkedList[Int]
    list1.insertAt(0, 10)
    list1.insertAt(1, 9)
    list1.insertAt(2, 11)
    list1.insertAt(3, 11)
    list1.insertAt(4, 16)

    list1.show
    println(list1.elementAt(2))
    println(list1.find(11))

    list1.clear
    println()
    list1.show
  }

}
