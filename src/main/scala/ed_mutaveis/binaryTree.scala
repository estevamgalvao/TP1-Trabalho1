package ed_mutaveis


case class nodeTree[T <% Ordered[T]](var value: T, var leftNode: nodeTree[T] = null,
                       var rightNode: nodeTree[T] = null)

class binaryTree[T <% Ordered[T]] extends traitBinaryTree[T] {
  private var root: nodeTree[T] = _

  override def insert(value: T): Unit = {
    if (root == null) {
      root = nodeTree[T](value)

    }
    else {
      val currentNode: nodeTree[T] = searchLeaf(value)
      if (currentNode != null) {
        if (value > currentNode.value) {
          currentNode.rightNode = nodeTree[T](value)
        }
        else {
          currentNode.leftNode = nodeTree[T](value)
        }
      }
      else println("member (" + value + ") already inserted !")
    }
  }


  def remove(value: T): Unit = {

    var removedNode = searchValue(value)
    var father = getFather(removedNode.value)

    if (removedNode == null){
      println("empty tree or value not found")
    }
    else {
      if (father == null) {                                                             //remoção da raiz
          if(removedNode.leftNode != null && removedNode.rightNode != null){
            val auxValue = maxValue(removedNode.leftNode)
            remove(auxValue)
            removedNode.value = auxValue
          }
          else if(removedNode.leftNode != null && removedNode.rightNode == null){
            val auxValue = maxValue(removedNode.leftNode)
            remove(auxValue)
            removedNode.value = auxValue
          }
          else if(removedNode.rightNode != null && removedNode.leftNode == null){

            val auxValue = minValue(removedNode.rightNode)
            remove(auxValue)
            removedNode.value = auxValue
          }

      }

      else {
        if (removedNode.value < father.value) {
          if (removedNode.leftNode == null && removedNode.rightNode == null) {
            father.leftNode = null
          }
          else if (removedNode.rightNode != null && removedNode.leftNode != null){
            val auxValue = minValue(removedNode.rightNode)
            remove(auxValue)
            father.leftNode.value = auxValue
          }
          else if (removedNode.leftNode != null && removedNode.rightNode == null){
            val auxValue = maxValue(removedNode.leftNode)
            remove(auxValue)
            father.leftNode.value = auxValue
          }
          else if (removedNode.rightNode != null && removedNode.leftNode == null){
            val auxValue = minValue(removedNode.rightNode)
            remove(auxValue)
            father.leftNode.value = auxValue
          }
        }
        else if (removedNode.value > father.value) {

          if (removedNode.leftNode == null && removedNode.rightNode == null) {
            father.rightNode = null
          }
          else if(removedNode.rightNode != null && removedNode != null){
            val auxValue = minValue(removedNode.rightNode)
            remove(auxValue)
            father.rightNode.value = auxValue
          }
          else if(removedNode.leftNode != null && removedNode.rightNode == null){
            val auxValue = maxValue(removedNode.leftNode)
            remove(auxValue)
            father.rightNode.value = auxValue
          }
          else if(removedNode.rightNode != null && removedNode.leftNode == null){
            val auxValue = minValue(removedNode.rightNode)
            remove(auxValue)
            father.rightNode.value = auxValue
          }
        }
      }
    }
  }

  def exist(value: T): Boolean = {
    val currentNode = searchValue(value, root)
    currentNode match {
      case null => false
      case nodeTree => true
    }
  }

  override def size(node : nodeTree[T] = root): Int ={
    if(node == null) return 0
    else{
      size(node.leftNode)
      size(node.rightNode)
      var sizeTree = size(node.leftNode) + size(node.rightNode) + 1
      return sizeTree
    }
  }

  private def searchLeaf(value: T, node: nodeTree[T] = root): nodeTree[T] = {
    if (node.value == value) {
      return null
    }
    else if (value > node.value) {
      if(node.rightNode != null) {
        return searchLeaf(value, node.rightNode)
      }
      else return node
    }
    else {
      if (node.leftNode != null) {
        return searchLeaf(value, node.leftNode)
      }
      else return node
    }
  }

  private def searchValue(value: T, node: nodeTree[T] = root): nodeTree[T] = {
    if (node.value == value) {
      return node
    }
    else if (value > node.value && node.rightNode != null) {
      return searchValue(value, node.rightNode)
    }
    else if (node.leftNode != null) {
      return searchValue(value, node.leftNode)
    }
    else {
      return null
    }
  }

  private def getFather(value:T, node : nodeTree[T] = root) : nodeTree[T] = {

    if(value == node.value){
      return null
    }
    else {
      if(node.rightNode != null && node.rightNode.value == value ||node.leftNode != null && node.leftNode.value == value) {
        return node
      }
      else{
        if(value < node.value){
          return getFather(value, node.leftNode)
        }
        else  {
          return getFather(value, node.rightNode)
        }
      }
    }
  }

  def showInOrder(node : nodeTree[T] = root): Unit = {

    if(node == null) return
    showInOrder(node.leftNode)
    println(node.value)
    showInOrder(node.rightNode)

  }

  def showPreOrder (node : nodeTree[T] = root) : Unit = {
    if(node == null) return
    println(node.value)
    showPreOrder(node.leftNode)
    showPreOrder(node.rightNode)
  }

  def minValue(node : nodeTree[T] = root ): T = {
    node.leftNode match {
      case null => node.value
      case nodeTree => minValue(node.leftNode)
    }
  }

  def maxValue(node : nodeTree[T] = root): T = {
    node.rightNode match {
      case null => node.value
      case nodeTree => maxValue(node.rightNode)
    }
  }

}