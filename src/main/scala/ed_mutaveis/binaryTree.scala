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

    else {
      while (verifier) {
        println("Current Node: " + currentNode.value)
        /* Indo para a direita */
        if (func(value, currentNode.value)) {
          if (currentNode.rightNode != null) { // Verifico se o próximo é nulo para conseguir comparar
            if (currentNode.rightNode.value == value) verifier = false
            else currentNode = currentNode.rightNode
          }
          else {
            println("there is nothing")
            return None
//            verifier = false
          }
        }

        /* Indo para a esquerda */
        else {
          if (currentNode.leftNode != null) {
            if (currentNode.leftNode.value == value) verifier = false
            else currentNode = currentNode.leftNode
          }
          else {
            println("there is nothing")
            return None
//            verifier = false
          }
        }
      }
      return Some(currentNode)
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
    if (_size == 0) {
      root = null
      return true
    }
    else {
      if (findLeaf(value, 1) != None) {
        val nodeAux: nodeTree[T] = findLeaf(value, 1).get

        if (func(value, nodeAux.value)) {
          nodeAux.leftNode = null
          _size -= 1
          return true
        }
        else {
          nodeAux.rightNode = null
          _size -= 1
          return true
        }
      }
      else false
    }
  }

  override def show: Unit = {




  }

  override def updateHead(value: T): Unit = ???

  override def size: Int = _size
}
