package ed_mutaveis
import ed_mutaveis.linkedList



class linkedListIterator[T](list: linkedList[T]) extends traitListIterator[T] {
  var currentNode: nodeList[T] = list.nodePointer(0)
  var _lastVisited: nodeList[T] = list.nodePointer(0)
  var currentPos: Int = 0
  var lastPos: Int = 0

  override def begin: T = list.nodePointer(0).value

  override def current: T = currentNode.value

  override def end: T = list.nodePointer(list.size - 1).value

  override def lastVisited: T = _lastVisited.value

  override def moveBegin: Unit = {
    _lastVisited = currentNode
    lastPos = currentPos
    currentNode = list.nodePointer(0)
    currentPos = 0
  }

  override def moveEnd: Unit = {
    _lastVisited = currentNode
    lastPos = currentPos
    currentNode = list.nodePointer(list.size - 1)
    currentPos = list.size - 1
  }

  override def moveLastVisited: Unit = {
    val aux: nodeList[T] = _lastVisited
    val auxPos: Int = lastPos
    _lastVisited = currentNode
    lastPos = currentPos
    currentNode = aux
    currentPos = auxPos
  }

  override def moveNext: Unit = {
    if (currentNode.nextNode != null) {
      _lastVisited = currentNode
      lastPos = currentPos
      currentNode = currentNode.nextNode
      currentPos += 1
    }
    else println("endline")
  }

  override def movePrev: Unit = {
    if (list.nodePointer(currentPos - 1) != null) {
      _lastVisited = currentNode
      lastPos = currentPos
      currentNode = list.nodePointer(currentPos - 1)
      currentPos -= 1
    }
    else println("endline")
  }


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
    if (list.nodePointer(currentPos - 1) != null) {
      Some(list.nodePointer(currentPos - 1).value)
    }
    else {
      println("there is nothing")
      None
    }
  }
}
