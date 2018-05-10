package ed_mutaveis
import org.scalatest._

class linkedListSpec extends FlatSpec with Matchers with BeforeAndAfter {
  behavior of "A Linked List"

  var lList : linkedList[Int] = _
  before{
    lList = new linkedList[Int]
  }
  it should "have size 0 / empty, before stacking any element" in {
    lList.size should be(0)
    lList.isEmpty should be(true)
  }

  it should "correspond the correct size value to insert and remove functions" in {
    lList.insert(2)
    lList.insertAt(0, 1)
    lList.remove(2)
    lList.removeAt(0)

    lList.size should be(0)
  }

  it should "push elements forward when inserting in a occupied position" in {
    lList.insert(1)
    lList.insertAt(1, 2)         //element pushed by the insertion of 3
    lList.insertAt(1, 3)

    lList.elementAt(1) should be(Some(3))
    lList.elementAt(2) should be(Some(2))
  }

  it should "push elements backwards when removing elements in the middle of the list" in {
    lList.insert(1)
    lList.insert(2)
    lList.insert(3)
    lList.insert(4)

    lList.elementAt(1) should be (Some(2))
    lList.elementAt(2) should be (Some(3))
    lList.removeAt(1)
    lList.elementAt(1) should be (Some(3))               //element pushed backwards
    lList.elementAt(2) should be (Some(4))               //element pushed backwards
  }

  it should "find elements" in {
    lList.insert(1)
    lList.insert(2)
    lList.insert(3)

    lList.find(1) should be(Some(0))
    lList.find(2) should be(Some(1))
    lList.find(3) should be(Some(2))
    lList.find(4) should be(None)
  }

  it should "count how many elements the list contains" in {
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
    lList.insert(1)
    lList.insert(2)
    lList.insert(3)
    lList.clear
    lList.size should be(0)
    lList.elementAt(0) should be(None)
  }

  it should "throw an exception when trying to remove from a empty list" in {
    intercept[NullPointerException]{
      lList.remove(2)
    }
  }

  it should "return false when trying to insert in a invalid position" in {
    lList.insertAt(-1,2) should be (false)
    lList.isEmpty should be (true)
    lList.size should be (0)
  }
}