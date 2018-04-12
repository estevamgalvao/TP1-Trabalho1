package ed_mutaveis

import java.security.KeyStore.TrustedCertificateEntry

import scala.io
import scala.io.StdIn

case class nodeList[T](value: T, var nextNode: nodeList[T]) //val serve para a lista imutável e var seria mutável

class linkedList[T] extends traitList[T] {
  private var _size: Int = 0
  private var head: nodeList[T] = _
  
  private def nodePointer(pos: Int): nodeList[T] = {
    var nodePointer = head
    for (i <- 0 until pos){
      nodePointer = nodePointer.nextNode
    }
    nodePointer
  }

  override def isEmpty: Boolean = head == null

  override def insertAt(pos: Int, value: T): Boolean = {
    if(pos >= 0 && pos <= _size) {

      if(pos == 0) {
        head = nodeList(value, head)
      }

      else {
        val currentNode = nodePointer(pos-1)
        currentNode.nextNode = nodeList(value, currentNode.nextNode)
      }

      _size += 1
      true
    }

    false
  }

  override def show: Unit = {
    var currentNode = head
    for (i <- 0 until _size){
      println(currentNode.value)
      currentNode = currentNode.nextNode
    }
  }































  override def clear: Unit = ???

  override def countElement(value: T): Int = ???

  override def elementAt(pos: Int): Option[T] = ???

  override def find(value: T): Option[T] = ???

  override def remove(value: T): Unit = ???

  override def removeAt(pos: Int): Unit = ???

  override def removeIf(func: T => Boolean): Int = ???

  override def reverse: Unit = ???

  override def size: Int = ???

  override def sort: Unit = ???
}
