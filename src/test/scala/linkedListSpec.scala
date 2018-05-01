package ed_mutaveis
import org.scalatest._

class linkedListSpec extends FlatSpec with Matchers {                          
  behavior of "A Linked List"

  it should "have size 0 / empty, before stacking any element" in {
    val lList = new linkedList[Int]
    lList.size should be(0)
    lList.isEmpty should be(true)
  }

  it should "correspond the correct size value to insert and remove functions" in {
    val lList = new linkedList[Int]
    lList.insert(2)
    lList.insertAt(0, 1)
    lList.remove(2)
    lList.removeAt(0)

    lList.size should be(0)
  }

  it should "push elements forward when inserting in a occupied position" in {
    val lList = new linkedList[Int]
    lList.insert(1)
    lList.insertAt(1, 2)
    lList.insertAt(1, 3)

    lList.elementAt(2) should be(Some(2))
  }

  it should "push elements backwards when removing elements in the middle of the list" in {
    val lList = new linkedList[Int]
    lList.insert(1)
    lList.insert(2)
    lList.insert(3)
    lList.insert(4)

    lList.elementAt(1) should be (Some(2))
    lList.elementAt(2) should be (Some(3))
    lList.removeAt(1)
    lList.elementAt(1) should be (Some(3))
    lList.elementAt(2) should be (Some(4))
  }

  it should "find elements" in {
    val lList = new linkedList[Int]
    lList.insert(1)
    lList.insert(2)
    lList.insert(3)

    lList.find(1) should be(Some(0))
    lList.find(2) should be(Some(1))
    lList.find(3) should be(Some(2))
    lList.find(4) should be(None)
  }

  it should "count elements" in {
    val lList = new linkedList[Int]
    lList.insert(1)
    lList.insert(2)
    lList.insert(2)
    lList.insert(1)
    lList.insert(1)

    lList.count(1) should be(3)
    lList.count(2) should be(2)
    lList.count(4) should be(0)
  }

  it should "clear it self" in {
    val lList = new linkedList[Int]
    lList.insert(1)
    lList.insert(2)
    lList.insert(3)
    lList.clear
    lList.size should be(0)
    lList.elementAt(0) should be(None)
  }
}