import ed_mutaveis.linkedList
import ed_mutaveis.Stack
import ed_mutaveis.Queue
import ed_mutaveis.doublyLinkedList
import ed_mutaveis.doublylistIterator

//val a: doublyLinkedList[Int] = new doublyLinkedList[Int]
//print(a.getClass.getSimpleName)


object Main {

  def main(args: Array[String]): Unit = {
    val dblist = new doublyLinkedList[Int]
    var k: Int = 10

    while (k != 0) {
      dblist.insert(k*k)
      k -= 1
    }

    print("Doubly List 1: ")
    dblist.show
    println("\n" + dblist.elementAt(dblist.size - 1))

    val it = new doublylistIterator[Int](dblist)
    println(it.current)
    for (i <- 1 until dblist.size) {
      it.moveNext
      println(it.current)
    }
    it.next

    dblist.clear
    dblist.show



  }
}
