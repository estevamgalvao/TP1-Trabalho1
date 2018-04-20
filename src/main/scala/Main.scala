import ed_mutaveis.linkedList
import ed_mutaveis.Stack
import ed_mutaveis.Queue
import ed_mutaveis.doublyLinkedList


object Main {

  def par(num: Int): Boolean = num%2 == 0

  def main(args: Array[String]): Unit = {

    var list1 = new linkedList[Int]
    var stack1 = new Stack[Int]
    var queue1 = new Queue[Int]
    var doublylist1 = new doublyLinkedList[Int]


    list1.insertAt(0,10)
    list1.insertAt(1,12)
    list1.insertAt(2,15)
    list1.insertAt(3, 30)
    stack1.insert(10)
    queue1.insert(8)
    doublylist1.insertAt(0, 10)
    doublylist1.insertAt(1, 11)
    doublylist1.insertAt(2, 12)
    doublylist1.insertAt(3, 13)
    doublylist1.insertAt(4, 14)
    doublylist1.insertAt(5, 22)
    doublylist1.insertAt(6, 29)
    val boolean = doublylist1.insertAt(80, 30)
    println(boolean)

    println("Size: " + doublylist1.size + "\n")
    doublylist1.show
    println()

    val boolean2 = doublylist1.remove(12)
    println("APAGUEI O 12")
    doublylist1.show
    println()
    doublylist1.remove(13)
    println("APAGUEI O 13")
    doublylist1.show
    println()
    doublylist1.remove(14)
    println("APAGUEI O 14")
    doublylist1.show
    println()
    doublylist1.remove(22)
    println("APAGUEI O 22")
    doublylist1.show
    println()
    doublylist1.remove(29)
    println("APAGUEI O 29")
    doublylist1.show
    println()
    doublylist1.remove(11)
    println("APAGUEI O 11")
    doublylist1.show
    println()
    doublylist1.remove(10)
    println("APAGUEI O 10")
    doublylist1.show
    doublylist1.show
  }

}
