package ed_mutaveis

trait traitBinaryTree[T] {
  def insert(value: T): Unit
  def remove(value: T): Boolean
  def updateHead(value: T): Unit
  def size: Int





}
