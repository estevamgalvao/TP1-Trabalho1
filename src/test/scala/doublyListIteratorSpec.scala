package ed_mutaveis
import org.scalatest._

class doublyListIteratorSpec extends FlatSpec with Matchers {
  behavior of "A Doubly Linked List Iterator"

  val dList = new doublyLinkedList[Int]
  dList.insert(1)
  dList.insert(2)
  dList.insert(3)
  dList.insert(4)

  val dListIt = new doublylistIterator[Int](dList)

  it should "point at the beginning of the list by default" in {
    dListIt.currentNode.value should be (1)
  }

  it should "point at the beginning of the list" in {
    dListIt.begin should be (1)
  }

  it should "point at the ending of the list" in {
    dListIt.end should be (4)
  }

  it should "move trough the list" in {
    dListIt.moveNext
    dListIt.currentNode.value should be (2)
    dListIt.moveNext
    dListIt.currentNode.value should be (3)
    dListIt.movePrev
    dListIt.currentNode.value should be (2)
    dListIt.movePrev
    dListIt.currentNode.value should be (1)
  }

  it should "move to last visited" in {
    dListIt.lastVisited should be (2)
    dListIt.currentNode.value should be (1)
    dListIt.moveLastVisited
    dListIt.currentNode.value should be (2)
  }
}


