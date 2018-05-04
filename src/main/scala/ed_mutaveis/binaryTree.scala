package ed_mutaveis


case class nodeTree[T](value: T, var leftNode: nodeTree[T],
                       var rightNode: nodeTree[T], var fatherNode: nodeTree[T])

class binaryTree[T](func: (T, T) => Boolean) extends traitBinaryTree[T] {
  private var root: nodeTree[T] = _
  private var _size: Int = 0
  private var height: Int = 0

  def findLeaf(value: T, mode: Int): Option[nodeTree[T]] = {
    var verifier: Boolean = true
    var currentNode: nodeTree[T] = root

    if (mode == 0) {
      while (verifier) {
        /* Indo para a direita */
        if (func(value, currentNode.value)) {
          if (currentNode.rightNode == null) verifier = false
          else currentNode = currentNode.rightNode
        }
        /* Indo para a esquerda */
        else {
          if (currentNode.leftNode == null) verifier = false
          else currentNode = currentNode.leftNode
        }
      }
      return Some(currentNode)
    }

    else if (mode == 1) {
      while (verifier) {
        /*Indo para a direita*/
        if (func(value, currentNode.value)) {
          if (currentNode.rightNode != null) {
            if (currentNode.rightNode.value == value) {
              currentNode = currentNode.rightNode
              return Some(currentNode)
            }
            else {
              currentNode = currentNode.rightNode
            }
          }
          else verifier = false
        }
          /*Indo para esquerda*/
        else {
          if (currentNode.leftNode != null) {
            if (currentNode.leftNode.value == value) {
              currentNode = currentNode.leftNode
              return Some(currentNode)
            }
            else {
              currentNode = currentNode.leftNode
            }
          }
          else verifier = false
        }
      }
      return None
    }

    else {
      return None
    }
  }

  override def insert(value: T): Unit = {
    if (_size == 0) {
      root = new nodeTree[T](value, null, null, null)
      _size += 1
    }
    else {
      val nodeAux: nodeTree[T] = findLeaf(value, 0).get
      if (func(value, nodeAux.value)) {
        nodeAux.rightNode = new nodeTree[T](value, null, null, nodeAux)
        _size += 1
      }
      else {
        nodeAux.leftNode = new nodeTree[T](value, null, null, nodeAux)
        _size += 1
      }
    }
  }

  override def remove(value: T): Boolean = {
    val nodeAux = findLeaf(value, 1).getOrElse(null)
//    if (nodeAux == root) {
//      if (nodeAux.rightNode != null) {
//
//      }
//    }
    if (nodeAux != null) {
      if (nodeAux.leftNode != null) {
        println("NodeAUX: " + nodeAux.value)
        nodeAux.fatherNode.leftNode = nodeAux.leftNode
        nodeAux.leftNode.fatherNode = nodeAux.fatherNode
        _size -= 1
        return true
      }
      if (nodeAux.rightNode != null) {
        nodeAux.fatherNode.rightNode = nodeAux.rightNode
        nodeAux.rightNode.fatherNode = nodeAux.fatherNode
        _size -= 1
        return true
      }
      else {
        if (func(value,nodeAux.fatherNode.value)) {
          nodeAux.fatherNode.rightNode = nodeAux.rightNode
          nodeAux.fatherNode = null
          _size -= 1
          return true
        }
        else {
          nodeAux.fatherNode.leftNode = nodeAux.leftNode
          nodeAux.fatherNode = null
          _size -= 1
          return true
        }
      }
    }
    else return false
  }


  override def show: Unit = {
    println("Root: " + root.value)
    println("Root -> Left: " + root.leftNode.value)
    println("Root -> Right: " + root.rightNode.value)
//    println("Root -> Left -> Left: " + root.leftNode.leftNode.value)

  }

  override def updateHead(value: T): Unit = ???

  override def size: Int = _size
}
