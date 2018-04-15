import ed_mutaveis.linkedList
import ed_mutaveis.Stack
import ed_mutaveis.Queue


object Main {

  def par(num: Int): Boolean = num%2 == 0

  def main(args: Array[String]): Unit = {

    var list1 = new linkedList[Int]
    var stack1 = new Stack[Int]
    var queue1 = new Queue[Int]

    queue1.insert(9)
    queue1.insert(10)
    queue1.insert(10)
    println(queue1.first)
    queue1.remove
    println(queue1.first)
    println(queue1.count(10))


//    list1.insertAt(0, 10)
//    list1.insert(14)
//    list1.insertAt(2, 9)
//    list1.insertAt(3, 11)
//
//    println(list1.size)
//    list1.removeAt(4)
//    list1.show
  }

}
