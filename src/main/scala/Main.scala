import ed_mutaveis.linkedList
import ed_mutaveis.Stack
import ed_mutaveis.Queue
import ed_mutaveis.doubleLinkedList


object Main {

  def par(num: Int): Boolean = num%2 == 0

  def main(args: Array[String]): Unit = {

    var list1 = new linkedList[Int]
    var stack1 = new Stack[Int]
    var queue1 = new Queue[Int]
    //var doublelist1 = new doubleLinkedList[Int]


    list1.insertAt(0,10)
    list1.insertAt(1,12)
    list1.insertAt(2,15)
    list1.insertAt(3, 30)
    stack1.insert(10)
    queue1.insert(8)
    //doublelist1.insertAt(0, 10)
    //doublelist1.insertAt(1, 11)
    //doublelist1.insertAt(2, 12)
    //doublelist1.insertAt(2, 12)

    //println(doublelist1.size)

    //doublelist1.show
    list1.filter(par)

    list1.show

  }

}
