package ed_mutaveis

/**
  * Uma implementação do tipo Deque utilizando um trait extendendo a classe DoublyLinkedList
  *
  * @author andreymazepas
  */
trait Deque[T] {
  def enqueueFront(value: T): Unit
  def dequeueFront(): Option[T]
  def enqueueBack(value: T): Unit
  def dequeueBack(): Option[T]
  def peekFront(): Option[T] 
  def peekBack(): Option[T] 
  def size(): Int
}
