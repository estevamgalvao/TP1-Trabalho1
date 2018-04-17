package ed_mutaveis


case class doubleNodeList[T](value: T, var nextNode: doubleNodeList[T], var prevNode: doubleNodeList[T])
case class pureNode[T](var nextNode: doubleNodeList[T], var prevNode: doubleNodeList[T])

class doubleLinkedList[T] extends traitList[T] {
  private var _size: Int = 0
  private var head: pureNode[T] = _
  private var end: pureNode[T] = _
  private var auxNode: doubleNodeList[T] = _

  private def nodePointer(pos: Int): doubleNodeList[T] = {
    if ((_size - pos) < pos){
      var nodePointer: doubleNodeList[T] = end.prevNode
      for (i <- pos until _size) {
        nodePointer = nodePointer.prevNode
      }
      nodePointer
    }
    else {
      var nodePointer: doubleNodeList[T] = head.nextNode
      for (i <- 0 until pos) {
        nodePointer = nodePointer.nextNode
      }
      nodePointer
    }
  }

  override def insertAt(pos: Int, value: T): Boolean = {
    if (pos >= 0 && pos <= _size) {
      if(head.nextNode == null){
        head = pureNode(auxNode, null)
        end = pureNode(null, auxNode)
        auxNode = doubleNodeList(value , auxNode, auxNode)
      }
      else {
        if (pos == 0) {
          val currentNode = new doubleNodeList[T](value, head.nextNode, null)
          head.nextNode = currentNode
          auxNode.prevNode = currentNode
        }
        else if (pos == _size){
          val currentNode = new doubleNodeList[T](value, null, end.prevNode)
          end.prevNode = currentNode
          auxNode.nextNode = currentNode
        }
        else{
          val currentNode = nodePointer(pos - 1)

        }
      }
    }
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
      var currentNode: doubleNodeList[T] = head
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
