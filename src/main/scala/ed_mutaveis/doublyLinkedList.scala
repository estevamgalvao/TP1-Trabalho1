package ed_mutaveis


case class doublyNodeList[T](value: T, var prevNode: doublyNodeList[T], var nextNode: doublyNodeList[T])

class doublyLinkedList[T] extends traitList[T] {
  private var _size: Int = 0
  private var head: doublyNodeList[T] = _
  private var end: doublyNodeList[T] = _

  private def nodePointer(pos: Int): doublyNodeList[T] = {
    if ((_size - pos) >= pos) {
      var currentNode: doublyNodeList[T] = head
      for (i <- 0 until pos) {
        currentNode = currentNode.nextNode
      }
      return currentNode
    }
    else {
      var currentNode: doublyNodeList[T] = end
      for (i <- pos until _size) {
        currentNode = currentNode.prevNode
      }
      println("Value nodePointer: " + currentNode.value)
      return currentNode
    }
  }


  override def insertAt(pos: Int, value: T): Boolean = {
    if (pos >= 0 && pos <= _size) {
      if (head == null) {
        head = doublyNodeList(value, null, null )

      }
      else if (head.nextNode == null) {
        end = doublyNodeList(value, head, null)
        head.nextNode = end
      }
      else if (pos == 0) {
        head = doublyNodeList(value, null, head)
        head.nextNode.prevNode = head
      }
      else if (pos == _size) {
        end = doublyNodeList(value, end, null)
        end.prevNode.nextNode = end
      }
      else {
        val currentNode = nodePointer(pos - 1)
        //Faço o novo elemento -cN.next pois será adicionado na frente- apontar para o .next do antigo "currentNode"
        // antigo -> current -> antigo.next
        currentNode.nextNode = doublyNodeList[T](value, currentNode, currentNode.nextNode)
        currentNode.nextNode.prevNode = currentNode
      }
      _size += 1
      return true
    }
    else println("invalid position"); return false
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

  override def filter(func: T => Boolean): Boolean = ???

  override def reverse: Unit = ???

  override def show: Unit = {
    if (isEmpty == false) {
      var currentNode: doublyNodeList[T] = head
//      println("\nlooool")
//      println(currentNode.value)
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
