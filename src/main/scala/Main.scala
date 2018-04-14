import ed_mutaveis.linkedList


object Main {

  def par(num: Int): Boolean = num%2 == 0

  def main(args: Array[String]): Unit = {

    var list1 = new linkedList[Int]
    list1.insertAt(0, 10)
    list1.insertAt(1, 9)
    list1.insertAt(2, 11)
    list1.insertAt(3, 16)
    list1.insertAt(4, 11)

    list1.show
    println(list1.elementAt(2))
    println(list1.find(11))

    list1.removeIf
    println()
    list1.show


  }

}
