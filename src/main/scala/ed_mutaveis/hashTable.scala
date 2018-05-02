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

  override def insert(value: T): Unit = {
    _array(hashFunc(value)).insert(value)
//    _array(hashFunc(value)).show
  }

  override def check(value: T): Option[Int] = {
    if (_array(hashFunc(value)).size == 0) {
      println("there is nothing")
      None
    }
    else {
      if (_array(hashFunc(value)).find(value).isDefined) {
        Some(hashFunc(value))
      }
      else None
    }
  }

  override def remove(value: T): Boolean = {
    if (_array(hashFunc(value)).size != 0) {
      _array(hashFunc(value)).remove(value)
      return true
    }
    else {
      println("there is nothing")
      return false
    }
  }

  override def removeAt(key: Int): Boolean = {
    _array(key).removeAt(_array(key).size - 1)
  }

  override def show: Unit = {
    var i: Int = 0
    while (i < size) {
      if (_array(i).size != 0) {
        for (j <- 0 until _array(i).size) {
          println("[Key: " + i + " | Value: " + _array(i).elementAt(j) + "]")
        }
      }
      i += 1
    }
  }

//  override def size: Int = ???


}
