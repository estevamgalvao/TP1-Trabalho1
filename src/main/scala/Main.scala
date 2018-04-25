import ed_mutaveis.linkedList
import ed_mutaveis.Stack
import ed_mutaveis.Queue
import ed_mutaveis.doublyLinkedList


object Main {

  def par(num: Int): Boolean = num%2 == 0

  def main(args: Array[String]): Unit = {

    val dblist = new doublyLinkedList[Int]
    val list = new linkedList[Int]


    dblist.insertAt(0, 10)
    dblist.insertAt(0, 1)
    dblist.insertAt(0, 10)
    dblist.show
    println()



    dblist.insertAt(2, 3)
    dblist.insert(45)
    dblist.show
    println()

//    println(dblist.size)

//    dblist.remove(45)
//    dblist.remove(1)
//    dblist.remove(3)
//    dblist.remove(15)
//    dblist.remove(10)
    dblist.removeAt(1)
    dblist.show

    println("Quantidade: " + dblist.count(10))

  }

}
