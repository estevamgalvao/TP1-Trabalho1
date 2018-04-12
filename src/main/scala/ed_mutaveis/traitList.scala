package ed_mutaveis

trait traitList[T] {
  def isEmpty: Boolean
  def size: Int
  def insertAt(pos: Int, value: T): Boolean
  def removeAt(pos: Int): Unit
  def remove(value: T): Unit
  def elementAt(pos: Int): Option[T]
  def find(value: T): Option[T]
  def sort: Unit
  def reverse: Unit
  def countElement(value: T): Int
  def clear: Unit
  def removeIf(func:(T) => Boolean): Int
  def show: Unit //A princípio mostrar os elementos, como um print. Depois pensar em retornar todos em uma lista.
}
