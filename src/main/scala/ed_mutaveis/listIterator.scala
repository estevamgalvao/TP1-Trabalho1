package ed_mutaveis

class listIterator[T] extends doublyLinkedList[T] with traitListIterator[T] {
  var _lastVisited: doublyNodeList[T] = _
  var currentNode: doublyNodeList[T] = _
  var currentList: traitList[T] = _

  override def assign(list: traitList[T]): Unit = {
    currentList = list
  }

  override def lastVisited: T = _lastVisited.value

  override def next: T = currentNode.nextNode.value

  override def prev: T = currentNode.prevNode.value

  override def moveLastVisited: Unit = currentNode = _lastVisited

  override def moveBegin: Unit = Some(currentNode) = currentList.elementAt(0)

  override def moveEnd: Unit = Some(currentNode) = currentList.elementAt(currentList.size-1)

  override def moveNext: Unit = {
    _lastVisited = currentNode
    currentNode = currentNode.nextNode
  }

  override def movePrev: Unit = {
    _lastVisited = currentNode
    currentNode = currentNode.prevNode
  }



}
