package ed_mutaveis

trait traitQueue[T] {
  def insert(value: T): Unit
  def remove: Boolean
  def first: Option[T]
  def size: Int
  def find(value: T): Option[Int]
  def clear: Unit
  def isEmpty: Boolean
  def count(value: T): Int

}
