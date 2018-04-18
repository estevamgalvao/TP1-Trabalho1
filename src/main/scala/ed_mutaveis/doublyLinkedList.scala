package ed_mutaveis


case class doublyNodeList[T](value: T, var nextNode: doublyNodeList[T], var prevNode: doublyNodeList[T])

class doubleLinkedList[T] extends traitList[T] {
  private var _size: Int = 0
  private var head: doublyNodeList[T] = _

  override def insertAt(pos: Int, value: T): Boolean = {


  }

  override def applyAll(func: T => Unit): Unit = ???

  override def clear: Unit = {

  }

  override def count(value: T): Int = ???

  override def elementAt(pos: Int): Option[T] = ???

  override def find(value: T): Option[Int] = ???

  override def insert(value: T): Unit = ???

  override def isEmpty: Boolean = head == null

  override def remove(value: T): Boolean = ???

  override def removeAt(pos: Int): Boolean = ???

  override def removeIf(func: T => Boolean): Boolean = ???

  override def reverse: Unit = ???

  override def show: Unit = {
    if (isEmpty == false) {
      var currentNode: doublyNodeList[T] = head
      println("\nlooool")
      println(currentNode.value)
      for (i <- 0 until _size) {
        println(currentNode.value)
        currentNode = currentNode.nextNode
      }
    }
    else {
      println("empty list")
    }
  }

  override def size: Int = _size

  override def sort: Unit = ???

}
