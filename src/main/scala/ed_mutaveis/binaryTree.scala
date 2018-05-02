package ed_mutaveis


case class nodeTree[T](value: T, var leftNode: nodeTree[T],
                       var rightNode: nodeTree[T], var fatherNode: nodeTree[T])

class binaryTree[T](func: (T, T) => Boolean) extends traitBinaryTree[T] {
  private var root: nodeTree[T] = _
  private var _size: Int = 0
  private var height: Int = 0

  def findLeaf(value: T): nodeTree[T] = {
    var verifier: Boolean = true
    var currentNode: nodeTree[T] = root

    else {
      while (verifier == true) {
        if (func(value, currentNode.value)) {
          if (currentNode.rightNode == null) verifier = false
          else currentNode = currentNode.rightNode
        }
        else {
          if (currentNode.leftNode == null) verifier = false
          else currentNode = currentNode.leftNode
        }
      }
      return currentNode
    }
  }


  override def insert(value: T): Unit = {
    if (_size == 0) {
      root = new nodeTree[T](value, null, null, null)
    }
    else {
      val nodeAux: nodeTree[T] = findLeaf(value)
      if (func(value, nodeAux.value)) {
        nodeAux.rightNode = new nodeTree[T](value, null, null, nodeAux)
      }
      else {
        nodeAux.leftNode = new nodeTree[T](value, null, null, nodeAux)
      }
    }

  }

  override def remove(value: T): Boolean = ???

  override def updateHead(value: T): Unit = ???

  override def size: Int = _size
}
