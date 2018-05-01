package ed_mutaveis

trait traitHashtable[T] {
  def insert(value: T): Unit
  def check(value: T): Boolean
  def remove(value: T): Boolean
  def removeAt(key: Int): Boolean
}
