import ed_mutaveis.linkedList
import ed_mutaveis.Stack
import ed_mutaveis.Queue
import ed_mutaveis.doublyLinkedList


object Main {

  def par(num: Int): Boolean = num%2 == 0

  def main(args: Array[String]): Unit = {
    var k: Int = 1
    val dblist = new doublyLinkedList[Int]
    val list = new linkedList[Int]


    dblist.insertAt(0, 10)
    dblist.insertAt(1, 20)
    dblist.insertAt(2, 15)

    println("\n" + k + "º Show:")
    dblist.show
    k+=1

    dblist.insert(40)
    println("\n" + k + "º Show:")
    dblist.show
    k+=1

    dblist.insert(33)
    println("\n" + k + "º Show:")
    dblist.show
    k+=1

//    dblist.removeAt(1)
//    println("\n" + k + "º Show:")
//    dblist.show
//    k+=1

    println("Elemento 0: " + dblist.elementAt(0))
    println("Elemento 1: " + dblist.elementAt(1))
    println("Elemento 2: " + dblist.elementAt(2))
    println("Elemento 3: " + dblist.elementAt(3))

    dblist.insertAt(4, 22)
    println("\n" + k + "º Show:")
    dblist.show
    k+=1

    println("Size: " + dblist.size + "\nElemento 4: " + dblist.elementAt(4))

//    dblist.insertAt(5, 28)
//    println("\n" + k + "º Show:")
//    dblist.show
//    k+=1

  }

}
