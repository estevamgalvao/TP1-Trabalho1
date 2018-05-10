package ed_mutaveis

trait traitBinaryTree[T] {
  def insert(value: T): Unit
  def exist(value: T): Boolean
  def remove(value: T): Unit
  def size(node: nodeTree[T]): Int

}
