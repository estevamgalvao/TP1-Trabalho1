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
      /* Retiro quando está balanceada */
      if (currentNode.rightNode != null) {
        /* Se há elemento na direita, eu dou um passo pra direita */
        currentNode = currentNode.rightNode
        /* Enquanto houver elemento na esquerda, ando pra esquerda */
        while (currentNode.leftNode != null) {
          currentNode = currentNode.leftNode
        }
        /* Verifico se meu último elemento da esquerda tiver elemento na direta */
        if (currentNode.rightNode != null) {
          println("dios mio")
        }
        else {
          //          println("XUBIRABIRON")
          currentNode.leftNode = auxNode.leftNode
//          println("AuxNode -> Left: " + auxNode.leftNode.value)
//          println("Current -> Left: " + currentNode.leftNode.value)
          currentNode.rightNode = auxNode.rightNode
          val father = currentNode.fatherNode
//          println("Father: " + father.value)
          currentNode.fatherNode = auxNode.fatherNode
//          println("Current -> Father: " + currentNode.fatherNode.value)
//          println("Root: " + root.value)
//          println("Current -> Father -> PréLeft: " + currentNode.fatherNode.leftNode.value)
          currentNode.fatherNode.leftNode = currentNode
//          println("Current -> Father -> PósLeft: " + currentNode.fatherNode.leftNode.value)
//          println("Current -> Father -> Left -> Left: " + currentNode.fatherNode.leftNode.leftNode.value)
//          println("Current -> Father -> Left -> Right: " + currentNode.fatherNode.leftNode.rightNode.value)
//          println("Root -> Father -> Left -> Left: " + root.leftNode.leftNode.value)
          auxNode.fatherNode = father

        }
      }
      /* Retiro quando o X a ser retirado não tem árvore na direita */
      else {
        if (func(value, currentNode.value)) {
          currentNode.rightNode.fatherNode = currentNode.fatherNode
          currentNode.fatherNode.rightNode = currentNode.rightNode
        }
        else {
          currentNode.leftNode.fatherNode = currentNode.fatherNode
          currentNode.fatherNode.leftNode = currentNode.leftNode
        }
      }
    }



  }

  override def show: Unit = {
    println("[" + root.value + "]")
    println("[" + root.leftNode.value + "]")
    println("Root -> Father -> Left -> Left: " + root.leftNode.leftNode.value)
//    println("[" + root.leftNode.leftNode.value + "]     [" + root.leftNode.rightNode.value + "]" )
//  println("[" + root.leftNode.leftNode.leftNode.value + "]  [" + root.leftNode.leftNode.rightNode.value + "]       ["
//    + root.leftNode.rightNode.leftNode.value + "]  [" + root.leftNode.rightNode.rightNode.value + "]" )

  }

  override def size: Int = _size

  override def updateHead(value: T): Unit = ???

}
