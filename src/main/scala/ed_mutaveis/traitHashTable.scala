package ed_mutaveis

trait traitHashTable[T] {
  def insert(value: T): Unit
  def check(value: T): Option[Int]
  def remove(value: T): Boolean
  def removeAt(key: Int): Boolean
  def show: Unit
  def size: Int
}
