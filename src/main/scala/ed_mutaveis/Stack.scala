package ed_mutaveis

class Stack[T] extends traitStack[T] {
  private val nodes: linkedList[T] = new linkedList[T]

  override def pop: Boolean = nodes.removeAt(nodes.size-1)

  override def top: Option[T] = nodes.elementAt(nodes.size-1)

  override def insert(value: T): Unit = nodes.insert(value)

  override def size: Int = nodes.size

  override def isEmpty: Boolean = nodes.isEmpty

  override def clear: Unit = nodes.clear

  override def count(value: T): Int = nodes.count(value)

  override def find(value: T): Option[Int] = nodes.find(value)
}
