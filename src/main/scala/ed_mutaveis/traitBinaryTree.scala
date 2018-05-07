package ed_mutaveis

trait traitBinaryTree[T] {
  def insert(value: T): Unit
  def exist(value: T): Boolean
  def size: Int

}
