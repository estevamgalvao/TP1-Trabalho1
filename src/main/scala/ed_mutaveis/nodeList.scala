package ed_mutaveis

case class nodeList[T](value: T, var nextNode: nodeList[T]) //val serve para a lista imutável e var seria mutável