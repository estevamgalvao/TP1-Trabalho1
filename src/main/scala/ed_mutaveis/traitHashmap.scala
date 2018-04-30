package ed_mutaveis

trait traitHashmap[T] {
  def insert(key: Int, value: T): Unit
  def check(key: Int): T
  def checkValue(value: T): Option[T]
  def remove(value: T)
  def removeAt(key: Int)



}
