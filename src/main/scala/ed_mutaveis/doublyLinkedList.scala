package ed_mutaveis


case class doublyNodeList[T](var value: T, var prevNode: doublyNodeList[T], var nextNode: doublyNodeList[T])

class doublyLinkedList[T] extends traitList[T] {
  private var _size: Int = 0
  private var head: doublyNodeList[T] = _
  private var end: doublyNodeList[T] = _

  /*head e end não são ponteiros!*/

  def nodePointer(pos: Int): doublyNodeList[T] = {
    if ((_size - pos) >= pos) { /*Verifico se vou percorrer do inicio pro fim ou do fim pro inicio de acordo com a menor distância*/
      var currentNode: doublyNodeList[T] = head
      for (i <- 0 until pos) { /*Se for menor percorrer do inicio*/
//        println("Variável i: " + i + "\nCurrent Node: " + currentNode.value)
        currentNode = currentNode.nextNode
      }
      return currentNode
    }
    else { /*Se for menor percorrer a partir do fim*/
      var currentNode: doublyNodeList[T] = end
      for (i <- pos until _size - 1) {
        currentNode = currentNode.prevNode
      }
      //println("Value nodePointer: " + currentNode.value)
      return currentNode
    }
  }

  override def insertAt(pos: Int, value: T): Boolean = { /*Função para inserir em uma posição específica*/
    if (pos >= 0 && pos <= _size) { /*Verifico se a posição é válida*/
      if (head == null) {
        head = doublyNodeList(value, null, null ) /*Caso em que a lista está vazia*/
      }
      else if (head.nextNode == null && pos != 0) { /*Caso em que só há a cabeça, então o próximo elemento tem que ser o end*/
        end = doublyNodeList(value, head, null)
        head.nextNode = end
      }
      else if (head.nextNode == null && pos == 0){ /*Caso em que só há a cabeça e querem atualizar a cabeça*/
        val valueAux = head.value /*Guardo o valor da minha antiga cabeça*/
        head = doublyNodeList(value, null, null) /*Reinicializo minha cabeça com o valor dado*/
        end = doublyNodeList(valueAux, head, null) /*Atualizo o end para ser minha antiga cabeça*/
        head.nextNode = end /*Ligo a nova cabeça e o end*/
      }
      else if (pos == 0) { /*Atualizo a cabeça*/
        head = doublyNodeList(value, null, head)
        head.nextNode.prevNode = head
      }
      else if (pos == _size) { /*Atualizo o end*/
        end = doublyNodeList(value, end, null)
        end.prevNode.nextNode = end
      }
      else {
        var currentNode = nodePointer(pos - 1)
        //Faço o novo elemento -cN.next pois será adicionado na frente- apontar para o .next do antigo "currentNode"
        //antigo -> current -> antigo.next
        currentNode.nextNode = doublyNodeList[T](value, currentNode, currentNode.nextNode)
        currentNode = currentNode.nextNode //ISSO AQUI RESOLVEU O PROBLEMA Q N LIGAVA DIREITO QUANDO ENTRAVA NESSE IF
        currentNode.nextNode.prevNode = currentNode
      }
      _size += 1
      return true
    }
    else {
      println("invalid position")
      return false
    }
  }

  override def insert(value: T): Unit = { /*Sempre insere no final da lista, se está vazia também a inicializa*/
    insertAt(_size, value)
  }

  override def applyAll(func: T => T): Unit = {
    var currentNode: doublyNodeList[T] = head
    for (i <- 0 until _size) {
      currentNode.value = func(currentNode.value)
      currentNode = currentNode.nextNode
    }
  }

  override def clear: Unit = {
    for (i <- 0 until _size){
      removeAt(0)
    }
  }

  override def count(value: T): Int = {
    var counter: Int = 0
    if (isEmpty == false) {
      var currentNode: doublyNodeList[T] = head
      for (i <- 0 until _size) {
        if (currentNode.value == value) {
          counter += 1
          currentNode = currentNode.nextNode
        }
        else {
          currentNode = currentNode.nextNode
        }
      }
      return counter
    }
    else
      return 0
  }

  override def elementAt(pos: Int): Option[T] = {
    if (isEmpty == false) {
//      print("PrintElementAt:\n")
//      print("End: " + end.value)
//      print("\nEnd.Previous: " + end.prevNode.value + "\n")
      if (pos >= 0 && pos <= _size - 1) {
        val currentNode: doublyNodeList[T] = nodePointer(pos)
        return Some(currentNode.value)
      }
      else {
        return None
      }
    }
    else return None
  }

  override def find(value: T): Option[Int] = {
    if (isEmpty == false) {
      var currentNode = head
      for (i <-0 until _size) {
        if (currentNode.value == value) {
          return Some(i)
        }
        else {
          currentNode = currentNode.nextNode
        }
      }
      return None
    }
    else None
  }

  override def isEmpty: Boolean = _size == 0

  override def remove(value: T): Boolean = {
    if (head.value == value) {
      head = head.nextNode
//      println("Head. -> NextNode -> Value: " + head.nextNode.value)
      _size -= 1
      return true
    }
    else if (end.value == value) {
      end = end.prevNode
      _size -= 1
    }
    else {
      var currentNode = head.nextNode
      for (i <- 1 until _size - 1) {
        //println("Current Node -> Valor: " + currentNode.value)
        //println("Current Node -> NextNode: " + currentNode.nextNode.value)
        if (currentNode.value == value) {
          currentNode.prevNode.nextNode = currentNode.nextNode
          currentNode.nextNode.prevNode = currentNode.prevNode
          _size -= 1
          return true
        }
        else {
          currentNode = currentNode.nextNode
        }
      }
    }
    return false
  }

  override def removeAt(pos: Int): Boolean = {
    if (pos >= 0 && pos <= _size - 1) {
      if (pos == 0) {
        head = head.nextNode
      }
      else if (pos == _size - 1){
        end = end.prevNode
      }
      else {
        val currentNode = nodePointer(pos)
//        println("Current Node Value: " + currentNode.value)
//        println("End Value: " + end.value)
//        println("End Value -> prev Node: " + end.prevNode.value)
        currentNode.prevNode.nextNode = currentNode.nextNode
        currentNode.nextNode.prevNode = currentNode.prevNode
      }
      _size -= 1
      return true
    }
    else{
      println("invalid position")
      return false
    }
  }

  override def show: Unit = {
    if (isEmpty == false) {
      var currentNode: doublyNodeList[T] = head
      print("[ ")
      for (i <- 0 until _size) {
        print(currentNode.value + " ")
        currentNode = currentNode.nextNode
      }
      print("]")
    }
    else {
      println("empty list")
    }
  }

  override def size: Int = _size

  override def filter(func: T => Boolean): Boolean = {
    var sizeAUX = _size
    var i = 0

    while(i < sizeAUX) {
      if(func(elementAt(i).get)) {
        sizeAUX -= 1
        removeAt(i)
      }
      else i += 1
    }
    return sizeAUX != _size
  }
}
