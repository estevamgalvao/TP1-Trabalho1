import ed_mutaveis.linkedList
import ed_mutaveis.Stack
import ed_mutaveis.Queue
import ed_mutaveis.doublyLinkedList


object Main {

  def par(num: Int): Boolean = num%2 == 0

  def main(args: Array[String]): Unit = {

    var dblist = new doublyLinkedList[Int]

    dblist.insertAt(0, 10)
    dblist.insertAt(0, 1)
    dblist.show

  }

}
