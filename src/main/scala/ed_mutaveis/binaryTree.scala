package ed_mutaveis


case class nodeTree[T](value: T, var leftNode: nodeTree[T],
                       var rightNode: nodeTree[T], var fatherNode: nodeTree[T])

class binaryTree[T](func: (T, T) => Boolean) extends traitBinaryTree[T] {
  private var root: nodeTree[T] = _
  private var _size: Int = 0
  private var height: Int = 0
//  private var emptyNode = nodeTree(null, null, null, null)

  def searchLeaf(value: T, node: nodeTree[T]): nodeTree[T] = {
    val currentNode = node
    if (currentNode.value == value) {
      return null
    }
    else if (func(value, currentNode.value)) {
      if(currentNode.rightNode != null) {
        return searchLeaf(value, currentNode.rightNode)
      }
      else return currentNode
    }
    else {
      if (currentNode.leftNode != null) {
        return searchLeaf(value, currentNode.leftNode)
      }
      else return currentNode
    }
  }

  def searchValue(value: T, node: nodeTree[T]): nodeTree[T] = {
    val currentNode = node
    if (currentNode.value == value) {
      return currentNode
    }
    else if (func(value, currentNode.value) && currentNode.rightNode != null) {
        return searchValue(value, currentNode.rightNode)
      }
    else if (currentNode.leftNode != null) {
        return searchValue(value, currentNode.leftNode)
    }
    else {
      return null
    }
  }

  override def insert(value: T): Unit = {
    if (_size == 0) {
      root = new nodeTree[T](value, null, null, null)
      _size += 1
    }
    else {
      val currentNode: nodeTree[T] = searchLeaf(value, root)
      if (currentNode != null) {
        if (func(value, currentNode.value)) {
          currentNode.rightNode = new nodeTree[T](value, null, null, currentNode)
          _size += 1
        }
        else {
          currentNode.leftNode = new nodeTree[T](value, null, null, currentNode)
          _size += 1
        }
      }
      else println("already exist")
    }
  }

  override def remove(value: T): Unit = {
    if (_size == 0) {
      println("empty tree")
      //      return false
    }
    else {
      var currentNode = searchValue(value, root)
      val auxNode = currentNode
      var leftCounter: Boolean = true
      /* Se há elemento na direita, eu dou um passo pra direita */
      if (currentNode.rightNode != null) {
        currentNode = currentNode.rightNode

        /* Enquanto houver elemento na esquerda, ando pra esquerda */
        while (currentNode.leftNode != null) {
          currentNode = currentNode.leftNode
          leftCounter = false
        }

        /* Não demos passo para a esquerda -> 1º e 2º caso*/
        if (leftCounter == true) {
          /*Algoritmo normal sem atualizar o cur.R*/
          currentNode.leftNode = auxNode.leftNode
          currentNode.leftNode.fatherNode = currentNode

          currentNode.fatherNode = auxNode.fatherNode
          if (func(value, currentNode.fatherNode.value)) {
            currentNode.fatherNode.rightNode = currentNode
          }
          else {
            currentNode.fatherNode.leftNode = currentNode
          }
          _size -= 1
        }
        /* Demos passo para esquerda */
        else {
          /*Demos passo para a esquerda e temos direita -> 3º caso*/
          if (currentNode.rightNode != null) {
            /*Adaptação para o caso da andei pra esqueda e tem direita*/
            currentNode.fatherNode.leftNode = currentNode.rightNode
            currentNode.rightNode.fatherNode = currentNode.fatherNode
            /*Algoritmo normal*/
            currentNode.leftNode = auxNode.leftNode
            currentNode.leftNode.fatherNode = currentNode

            currentNode.rightNode = auxNode.rightNode
            currentNode.rightNode.fatherNode = currentNode

            currentNode.fatherNode = auxNode.fatherNode
            if (func(value, currentNode.fatherNode.value)) {
              currentNode.fatherNode.rightNode = currentNode
            }
            else {
              currentNode.fatherNode.leftNode = currentNode
            }
            _size -= 1
          }

          /*Demos passo para a esquerda e não temos direita -> 5º caso*/
          else {
            currentNode.leftNode = auxNode.leftNode
            currentNode.leftNode.fatherNode = currentNode

            currentNode.rightNode = auxNode.rightNode
            currentNode.rightNode.fatherNode = currentNode

            currentNode.fatherNode = auxNode.fatherNode
            if (func(value, currentNode.fatherNode.value)) {
              currentNode.fatherNode.rightNode = currentNode
            }
            else {
              currentNode.fatherNode.leftNode = currentNode
            }
            _size -= 1
          }
        }
      }
      /*Não temos direita -> 4º caso*/
      else {
        currentNode.fatherNode.leftNode = currentNode.leftNode
        currentNode.leftNode.fatherNode = currentNode.fatherNode
        _size -= 1
      }
    }
  }

  override def show: Unit = {
    println("[" + root.value + "]")
    println("[" + root.leftNode.value + "]" + "[" + root.rightNode.value + "]")
    print("[" + root.leftNode.leftNode.value + "]     [" + root.leftNode.rightNode.value + "]    " )
    println("[" + root.rightNode.leftNode.value + "]     [" + root.rightNode.rightNode.value + "]" )
    println("[" + root.leftNode.rightNode.rightNode.value + "]")

    //    println("[" + root.rightNode.rightNode.leftNode.value + "]" + "    [" + root.rightNode.rightNode.rightNode.value + "]")

    //     println("[" + root.leftNode.leftNode.leftNode.value + "]  [" + root.leftNode.leftNode.rightNode.value + "]       ["
//    + root.leftNode.rightNode.leftNode.value + "]  [" + root.leftNode.rightNode.rightNode.value + "]" )

  }

  override def size: Int = _size

  override def updateHead(value: T): Unit = ???

}
