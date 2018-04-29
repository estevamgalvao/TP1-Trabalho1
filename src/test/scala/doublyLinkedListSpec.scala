package ed_mutaveis
import org.scalatest._

class doublyLinkedListSpec extends FlatSpec with Matchers {
  behavior of "A Doubly Linked List"

  it should "have size 0 / empty, before stacking any element" in{
    val dlist = new doublyLinkedList[Int]
    dlist.size should be (0)
    dlist.isEmpty should be (true)
  }

  it should "correspond the correct size value to insert and remove functions" in{
    val dlist = new doublyLinkedList[Int]
    dlist.insert(2)
    dlist.insertAt(0,1)
    dlist.remove(2)
    dlist.removeAt(0)

    dlist.size should be (0)
  }

  it should "push elements forward when inserting in a occupied position" in{
    val dList3 = new doublyLinkedList[Int]
    dList3.insert(1)
    dList3.insertAt(1,2)
    dList3.insertAt(1,3)

    dList3.elementAt(2) should be (Some(2))
  }

  it should "find elements" in{
    val dList = new doublyLinkedList[Int]
    dList.insert(1)
    dList.insert(2)
    dList.insert(3)

    dList.find(1) should be (Some(0))
    dList.find(2) should be (Some(1))
    dList.find(3) should be(Some(2))
    dList.find(4) should be (None)
  }

  it should "count elements" in{
    val dList = new doublyLinkedList[Int]
    dList.insert(1)
    dList.insert(2)
    dList.insert(2)
    dList.insert(1)
    dList.insert(1)

    dList.count(1) should be (3)
    dList.count(2) should be (2)
    dList.count(4) should be (0)
  }

  it should "clear it self" in{
    val dList = new doublyLinkedList[Int]
    dList.insert(1)
    dList.insert(2)
    dList.insert(3)
    dList.clear
    dList.size should be (0)
    dList.elementAt(0) should be (None)
  }


}
