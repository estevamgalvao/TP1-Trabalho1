package ed_mutaveis


case class nodeTree[T](value: T, leftNode: nodeTree[T],
                       rightNode: nodeTree[T], fatherNode: nodeTree[T])

class binaryTree[T](func: (T, T) => Boolean) extends traitBinaryTree[T] {
  private var oneAboveAll: nodeTree[T] = _
  private var _size: Int = 0
  private var height: Int = 0

  override def insert(value: T): Unit = {
    for (i <-0 to height) {
      //if esquerda == null
    }



  }

  override def remove(value: T): Boolean = ???

  override def updateHead(value: T): Unit = ???

  override def size: Int = _size
}
