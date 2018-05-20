package ed_mutaveis

class doublylistIterator[T](list: doublyLinkedList[T]) extends traitListIterator[T] {
  var _lastVisited: doublyNodeList[T] = list.nodePointer(0)
  var currentNode: doublyNodeList[T] = list.nodePointer(0)
  /*Inicializo ambas variáveis para começarem na cabeça*/

  override def lastVisited: T = _lastVisited.value

  override def next: Option[T] = { /*Função que retorna o valor do próximo nó*/
    if (currentNode.nextNode != null) {
      Some(currentNode.nextNode.value)
    }
    else {
      println("there is nothing")
      None
    }
  }

  override def prev: Option[T] = { /*Função que retorna o valor do nó anterior*/
    if (currentNode.prevNode != null) {
      Some(currentNode.prevNode.value)
    }
    else {
      println("there is nothing")
      None
    }
  }

  override def begin: T = list.nodePointer(0).value /*Função que retorna o valor da cabeça*/

  override def end: T = list.nodePointer(list.size - 1).value /*Função que retorna o valor do end*/

  override def current: T = currentNode.value /*Função que retorna o valor da posição atual do Iterator*/

  override def moveLastVisited: Unit = { /*Função que move para o último nó visitado*/
    val aux: doublyNodeList[T] = _lastVisited
    _lastVisited = currentNode
    currentNode = aux
  }

  override def moveNext: Unit = { /*Função que move para o próximo nó*/
    if (currentNode.nextNode != null) {
      _lastVisited = currentNode
      currentNode = currentNode.nextNode
    }
    else println("endline")
  }

  override def movePrev: Unit = { /*Função que move para o nó anterior*/
    if (currentNode.prevNode != null) {
      _lastVisited = currentNode
      currentNode = currentNode.prevNode
    }
    else println("endline")
  }

  override def moveBegin: Unit = { /*Função que move para o início*/
    _lastVisited = currentNode
    currentNode = list.nodePointer(0)
  }

  override def moveEnd: Unit = { /*Função que move para o end*/
    _lastVisited = currentNode
    currentNode = list.nodePointer(list.size - 1)
  }



}
