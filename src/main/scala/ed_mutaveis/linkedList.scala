package ed_mutaveis

import java.security.KeyStore.TrustedCertificateEntry
import scala.io
import scala.io.StdIn

case class nodeList[T](value: T, var nextNode: nodeList[T]) //val serve para a lista imutável e var seria mutável

class linkedList[T] extends traitList[T] {
  private var _size: Int = 0
  private var head: nodeList[T] = _
  
  private def nodePointer(pos: Int): nodeList[T] = {
    var nodePointer: nodeList[T] = head
    for (i <- 0 until pos){
      nodePointer = nodePointer.nextNode
    }
    nodePointer
  }

  override def isEmpty: Boolean = head == null

  override def size: Int = _size

  override def insertAt(pos: Int, value: T): Boolean = {
    if(pos >= 0 && pos <= _size) {
      if(pos == 0) {
        head = nodeList(value, head)
      }
      else {
        val currentNode: nodeList[T] = nodePointer(pos - 1)
        currentNode.nextNode = nodeList(value, currentNode.nextNode)
      }
      _size += 1
      return true
    }
    println("invalid position")
    false
  }

  override def insert(value: T): Unit = {
    insertAt(_size, value)
  }

  override def show: Unit = {
    if (isEmpty == false) {
      var currentNode: nodeList[T] = head
      for (i <- 0 until _size) {
        println(currentNode.value)
        currentNode = currentNode.nextNode
      }
    }
    else {
      println("empty list")
    }
  }

  override def removeAt(pos: Int): Boolean = {
    if (pos >= 0 && pos <= _size-1) {
      if (pos == 0) {
        head = head.nextNode
      }
      else {
        val currentNode: nodeList[T] = nodePointer(pos - 1)
        currentNode.nextNode = currentNode.nextNode.nextNode
      }
      _size -= 1
      return true
    }
    println("invalid position")
    false
  }

  override def remove(value: T): Boolean = {
    if (head.value == value){
      head = head.nextNode
      _size -= 1
      return true
    }
    else {
      var currentNode: nodeList[T] = head
      for (i <- 1 until _size) {
        if (currentNode.nextNode.value == value) {
          currentNode.nextNode = currentNode.nextNode.nextNode
          _size -= 1
          return true
        }
        else {
          currentNode = currentNode.nextNode
        }
      }
    }
    return false
  }

  override def count(value: T): Int = {
    var counter: Int = 0
    var currentNode: nodeList[T] = head

    for (i <- 0 until _size) {
      if (currentNode.value == value) {
        counter += 1
        currentNode = currentNode.nextNode
      }
      else {
        currentNode = currentNode.nextNode
      }
    }
    counter
  }

  override def elementAt(pos: Int): Option[T] = {
    if (pos >= 0 && pos <= _size-1){
      if(pos == 0){
        Some(head.value)
      }
      else {
        val currentNode: nodeList[T] = nodePointer(pos - 1)
        Some(currentNode.nextNode.value)
        //Usei o nextNode nessa chamada para manter a coerência
        //de índices na classe. Repare que a função nodePointer
        //sempre retornou o elemento anterior ao que eu queria.
      }
    }
    else{
      println("invalid position")
      None
    }
  }

  override def find(value: T): Option[Int] = {
    var currentNode: nodeList[T] = head
    for (i <- 0 until _size){
      if (currentNode.value == value){
        return Some(i)
      }
      else {
        currentNode = currentNode.nextNode
      }
    }
    None
  }

  override def clear: Unit = {
    for (i <- 0 until _size){
      removeAt(0)
    }
  }

//não sei como passar o valor de node.value para a função na main
  override def removeIf(func: T => Boolean): Boolean = {
    var verifier: Boolean = false
//    if (func(head.value) == true){
//      head = head.nextNode
//      _size -= 1
//      verifier = true
//    }
//    if {
      var currentNode: nodeList[T] = head
      for (i <- 0 until _size) {
        if (func(currentNode.value) == true){
          verifier = removeAt(i)
//          currentNode.nextNode = currentNode.nextNode.nextNode
//          _size -= 1
        }
        else {
          currentNode = currentNode.nextNode
        }
      }
    verifier
  }

  override def reverse: Unit = ???

  override def sort: Unit = ???

  override def applyAll(func: T => Unit): Unit = ???
}
