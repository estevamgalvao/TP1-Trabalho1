package ed_mutaveis

class hashTable[T](size: Int, hashFunc: T => Int) extends traitHashTable[T] {
  private val _array: Array[doublyLinkedList[T]] = new Array[doublyLinkedList[T]](size)

  for (i <- 0 until size) {
    _array(i) = new doublyLinkedList[T]
  }

//  protected def hashFunc(value: T): Any = {
//    var index: Any = 0
//    if (value.getClass.getSimpleName == "int") {
//  }
//    else if (value.getClass.getSimpleName == "double") {
//
//  }
//    else if (value.getClass.getSimpleName == "String") {
//
//  }
//  return 265443576
//  }

  override def insert(value: T): Unit = { /*Com função hash mapeia o valor em algum índice*/
    _array(hashFunc(value)).insert(value)
//    _array(hashFunc(value)).show
  }

  override def check(value: T): Option[Int] = {
    if (_array(hashFunc(value)).size == 0) {
      println("there is nothing")
      None
    }
    else {
      /*Podem ter havido colisões, então busco na lista (usando seu método find) do índice array[n] se o elemento existe. Assim vou varrendo o array*/
      /*isDefined me retorna true caso encontre um Option(Some)*/
      if (_array(hashFunc(value)).find(value).isDefined) {
        Some(hashFunc(value))
      }
      else None
    }
  }

  override def remove(value: T): Boolean = { /*Percorro o hash e excluo o primeiro valor igual ao valor dado*/
    if (_array(hashFunc(value)).size != 0) {
      _array(hashFunc(value)).remove(value)
      return true
    }
    else {
      println("there is nothing")
      return false
    }
  }

  override def removeAt(key: Int): Boolean = { /*Excluo o elemento dado a chave*/
    _array(key).removeAt(_array(key).size - 1)
  }

  override def show: Unit = { /*Mostro os elementos do hash*/
    var i: Int = 0
    while (i < size) {
      if (_array(i).size != 0) {
        for (j <- 0 until _array(i).size) {
          println("[Key: " + i + "/" + j + " | Value: " + _array(i).elementAt(j) + "]")
        }
      }
      i += 1
    }
  }

}
