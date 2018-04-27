import ed_mutaveis.linkedList
import ed_mutaveis.Stack
import ed_mutaveis.Queue
import ed_mutaveis.doublyLinkedList

object Main {

  def main(args: Array[String]): Unit = {
    val a: doublyLinkedList[Int] = new doublyLinkedList[Int]
    val b: Int = 1
    print(a.getClass.getSimpleName)
  }
}
