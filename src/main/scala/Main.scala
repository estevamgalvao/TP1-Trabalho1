import ed_mutaveis.linkedList
import ed_mutaveis.Stack


object Main {

  def par(num: Int): Boolean = num%2 == 0

  def main(args: Array[String]): Unit = {

    var list1 = new linkedList[Int]
    var stack1 = new Stack[Int]

    stack1.insert(9)
    stack1.insert(10)
    stack1.insert(18)
    println(stack1.top)
    stack1.pop
    println(stack1.top)


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
