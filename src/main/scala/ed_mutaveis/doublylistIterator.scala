package ed_mutaveis

class doublylistIterator[T](list: doublyLinkedList[T]) extends traitListIterator[T] {
  var _lastVisited: doublyNodeList[T] = list.nodePointer(0)
  var currentNode: doublyNodeList[T] = list.nodePointer(0)

  override def lastVisited: T = _lastVisited.value

  override def next: Option[T] = {
    if (currentNode.nextNode != null) {
      Some(currentNode.nextNode.value)
    }
    else {
      println("there is nothing")
      None
    }
  }

  override def prev: Option[T] = {
    if (currentNode.prevNode != null) {
      Some(currentNode.prevNode.value)
    }
    else {
      println("there is nothing")
      None
    }
  }

  override def begin: T = list.nodePointer(0).value

  override def end: T = list.nodePointer(list.size - 1).value

  override def current: T = currentNode.value

  override def moveLastVisited: Unit = {
    val aux: doublyNodeList[T] = _lastVisited
    _lastVisited = currentNode
    currentNode = aux
  }

  override def moveNext: Unit = {
    if (currentNode.nextNode != null) {
      _lastVisited = currentNode
      currentNode = currentNode.nextNode
    }
    else println("endline")
  }

  override def movePrev: Unit = {
    if (currentNode.prevNode != null) {
      _lastVisited = currentNode
      currentNode = currentNode.prevNode
    }
    else println("endline")
  }

  override def moveBegin: Unit = {
    _lastVisited = currentNode
    currentNode = list.nodePointer(0)
  }

  override def moveEnd: Unit = {
    _lastVisited = currentNode
    currentNode = list.nodePointer(list.size - 1)
  }



}
