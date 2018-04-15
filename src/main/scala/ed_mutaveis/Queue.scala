package ed_mutaveis

class Queue[T] extends traitQueue[T] {
  private val nodes: linkedList[T] = new linkedList[T]

  override def isEmpty: Boolean = nodes.isEmpty

  override def insert(value: T): Unit = nodes.insert(value)

  override def remove: Boolean = nodes.removeAt(0)

  override def first: Option[T] = nodes.elementAt(0)

  override def size: Int = nodes.size

  override def clear: Unit = nodes.clear

  override def count(value: T): Int = nodes.count(value)

  override def find(value: T): Option[Int] = nodes.find(value)
}
