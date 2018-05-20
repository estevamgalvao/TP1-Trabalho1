import ed_mutaveis.linkedList
import ed_mutaveis.Stack
import ed_mutaveis.hashTable
import ed_mutaveis.doublyLinkedList
import ed_mutaveis.doublylistIterator
import ed_mutaveis.linkedListIterator
import ed_mutaveis.binaryTree

//val a: doublyLinkedList[Int] = new doublyLinkedList[Int]
//print(a.getClass.getSimpleName)
//val leobomba = "lembo"
//val intbomba = 2
//val floatbobma = 2.4
//
//
//println(leobomba.getClass.getSimpleName == "String")
//println(intbomba.getClass.getSimpleName)
//println(floatbobma.getClass.getSimpleName)






object Main {
  def multPrime(value: Int): Int = {
    val aux: Int = (value * 265443576)%100
    return aux
  }

  def compare(num1: Int, num2: Int): Boolean = {
    if (num1>num2) true
    else false
  }

  def main(args: Array[String]): Unit = {
    val dblist = new doublyLinkedList[Int]
    val list1 = new linkedList[Int]
    val dic1 = new hashTable[Int](100, multPrime)



    //    println()
    //    tree1.show

    dic1.insert(1)
    dic1.insert(23123)
    dic1.insert(343)
    dic1.show

    println("\nCheck: " + dic1.check(23123).getOrElse())

    dic1.remove(3143)
    dic1.removeAt(76)
    dic1.show


  }
}
