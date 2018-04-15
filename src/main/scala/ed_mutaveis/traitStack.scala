package ed_mutaveis

trait traitStack[T] {
  def insert(value: T): Unit
  def pop: Boolean
  def top: Option[T]
  def size: Int
  def find(value: T): Option[Int]
  def clear: Unit
  def isEmpty: Boolean
  def count(value: T): Int
}
