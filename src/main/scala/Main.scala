import ed_mutaveis.linkedList


object Main {

  def main(args: Array[String]): Unit = {

    var list1 = new linkedList[Int]
    println(list1.isEmpty)

    list1.insertAt(0, 10)
    list1.insertAt(1, 9)
    list1.insertAt(2, 11)
    println(list1.isEmpty)

    list1.show

  }

}
