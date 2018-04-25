import ed_mutaveis.linkedList
import ed_mutaveis.Stack
import ed_mutaveis.Queue
import ed_mutaveis.doublyLinkedList

object Main {

  def par(num: Int): Boolean = num%2 == 0

  def main(args: Array[String]): Unit = {
    var k = 1
    val dblist = new doublyLinkedList[Int]
    val list = new linkedList[Int]

    dblist.insert(1)
    dblist.insert(1)
    dblist.insert(11)
    println("\n" + k + "º Show:")
    dblist.show
    k+=1

    dblist.filter(par)
    println("\n" + k + "º Show:")
    dblist.show
    k+=1
    
  }

}
