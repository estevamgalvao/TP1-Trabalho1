package ed_mutaveis

import java.security.KeyStore.TrustedCertificateEntry

import scala.io
import scala.io.StdIn
import scala.reflect.ClassTag

case class nodeList[T](var value: T, var nextNode: nodeList[T]) //val serve para a lista imutável e var seria mutável

class linkedList[T] extends traitList[T] {
  private var _size: Int = 0
  protected var head: nodeList[T] = _
//  protected val _type: ClassTag[T] = (ClassTag: T).getClass.getSimpleName
//    Class[T].asInstanceOf


//  println("Type: " +  (ClassTag[T]).getClass.getSimpleName)
//    Class[T].getClass.getSimpleName)

  def nodePointer(pos: Int): nodeList[T] = {
    var nodePointer: nodeList[T] = head
    for (i <- 0 until pos){
      nodePointer = nodePointer.nextNode
    }
    nodePointer
  }

  override def isEmpty: Boolean = head == null /*Verifico se a lista está vazia*/

  override def size: Int = _size

  override def insertAt(pos: Int, value: T): Boolean = { /*Função para inserir em uma posição específica*/
    if(pos >= 0 && pos <= _size) { /*Verifico se a posição é válida*/
      if(pos == 0) { /*Se for 0 é inserido automaticamente na cabeça*/
        head = nodeList(value, head)
      }
      else { /*Caso contrário percorro a lista até a posição usando a função nodePointer que me devolve a referencia p/ posição - 1*/
        val currentNode: nodeList[T] = nodePointer(pos - 1)
        currentNode.nextNode = nodeList(value, currentNode.nextNode)
      }
      _size += 1 /*Se digitou uma posição válida então incremento o tamanho pois com certeza o elemento será inserido*/
      return true
    }
    println("invalid position") /*Caso não digitou uma posição válida retorno uma mensagem de erro*/
    false
  }

  override def insert(value: T): Unit = { /*Sempre insere no final da lista, se está vazia também a inicializa*/
    insertAt(_size, value)
  }

  override def show: Unit = { /*Imprime na tela os elementos da lista*/
    if (isEmpty == false) {
      var currentNode: nodeList[T] = head
      print("[ ")
      for (i <- 0 until _size) {
        print(currentNode.value + " ")
        currentNode = currentNode.nextNode
      }
      print("]")
    }
    else { /*Se estiver vazia retorna uma mensagem de erro*/
      println("empty list")
    }
  }

  override def removeAt(pos: Int): Boolean = { /*Remove um elemento na posição dada*/
    if (pos >= 0 && pos <= _size-1) { /*Verifico se a posição é válida*/
      if (pos == 0) { /*No caso de remover a cabeça*/
        head = head.nextNode
      }
      else { /*Percorro a lista e faço o "ponteiro" de currentNode apontar pro ponteiro de currentNode.next*/
        val currentNode: nodeList[T] = nodePointer(pos - 1)
        currentNode.nextNode = currentNode.nextNode.nextNode
      }
      _size -= 1 /*Decremento o tamanho porque se a posição é válida com certeza algum elemento será removido*/
      return true
    }
    println("invalid position") /*Caso não digitou uma posição válida retorno uma mensagem de erro*/
    false
  }

  override def remove(value: T): Boolean = { /*Remove um dado elemento da lista ou o primeiro encontrado de mesmo valor*/
    if (head.value == value){
      head = head.nextNode
      _size -= 1
      return true
    }
    else {
      var currentNode: nodeList[T] = head
      for (i <- 1 until _size) { /*Percorro a lista a partir da cabeça, sendo que ela já foi verificada. então [1,_size]*/
        if (currentNode.nextNode.value == value) { /*Verifico se o next do meu elemento é o valor procurado, se for faço next=next.next*/
          currentNode.nextNode = currentNode.nextNode.nextNode
          _size -= 1
          return true
        }
        else {
          currentNode = currentNode.nextNode /*Modo como percorro a lista*/
        }
      }
    }
    return false
  }

  override def count(value: T): Int = { /*Conto quantas instâncias de dado elemento estão presentes na lista*/
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

  override def elementAt(pos: Int): Option[T] = { /*Retorno o elemento em dada posição*/
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

  override def find(value: T): Option[Int] = { /*Retorno a posição de dado elemento*/
    var currentNode: nodeList[T] = head
    for (i <- 0 until _size){
      if (currentNode.value == value){
        return Some(i)
      }
      else {
        currentNode = currentNode.nextNode
      }
    }
    None /*Caso não exista tal elemento na lista*/
  }

  override def clear: Unit = { /*Excluo todos os elementos da lista usando o removeAt sempre na cabeça que se atualizando -> [0,1,3] [1,3] [3] []*/
    for (i <- 0 until _size){
      removeAt(0)
    }
  }

  override def filter(func: T => Boolean): Boolean = { /*Excluo todos os elementos que atendem a condição passada*/
    var sizeAUX = _size
    var i = 0

    while(i < sizeAUX) {
      if(func(elementAt(i).get)) {
        sizeAUX -= 1
        remove(elementAt(i).get)
      }
      else i += 1
    }
    return sizeAUX != _size
  }

  override def applyAll(func: T => T): Unit = { /*Aplico a todos os elementos a operação passada*/
    var currentNode: nodeList[T] = head
    for (i <- 0 until _size) {
      currentNode.value = func(currentNode.value)
      currentNode = currentNode.nextNode
    }
  }

  override def modify(pos: Int, NewValue: T) : Unit = {
    var currentNode = nodePointer(pos)
    currentNode.value = NewValue
  }
}
