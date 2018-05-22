package ed_mutaveis

/**
  * Uma implementacao do tipo deque usando
  * Doubly Linked List
  *
  * @author: andreymazepas
  */
class DequeImpl[T] extends Deque[T] {
    private val elements = new doublyLinkedList[T]()
    private var _size = 0

    def enqueueFront(value: T): Unit = {
        elements.insertAt(0, value)
        _size += 1
    }

    def enqueueBack(value: T): Unit = {
        elements.insertAt(_size, value)
        _size += 1
    }

    def dequeueFront(): Option[T] = {
        val res = elements.elementAt(0)
        res match {
            case Some(v) => {
                elements.removeAt(0)
                _size -= 1
            }
            case None => {}
        }
        return res
    }

    def dequeueBack(): Option[T] = {
        val res = elements.elementAt(_size-1)
        res match {
            case Some(v) => {
                elements.removeAt(_size-1)
                _size -= 1
            }
            case None => {}
        }
        return res
    }

    def peekFront(): Option[T] = elements.elementAt(0)

    def peekBack(): Option[T] = elements.elementAt(_size-1)
    
    def size(): Int = _size
}