package ed_mutaveis
import org.scalatest._

class doublyLinkedListSpec extends FlatSpec with Matchers with BeforeAndAfter {
  behavior of "A Doubly Linked List"

  var dList: doublyLinkedList[Int] = _
  before{
    dList = new doublyLinkedList[Int]
  }


  it should "have size 0 / empty, before stacking any element" in{

    dList.size should be (0)
    dList.isEmpty should be (true)
  }

  it should "correspond the correct size value to insert and remove functions" in{

    dList.insert(2)
    dList.insertAt(0,1)
    dList.remove(2)
    dList.removeAt(0)

    dList.size should be (0)
  }

  it should "push elements forward when inserting in a occupied position" in{
    dList.insert(1)
    dList.insertAt(1,2)              //element pushed by the insertion below
    dList.insertAt(1,3)

    dList.elementAt(2) should be (Some(2))
  }
  it should "push elements backwards when removing elements in the middle of the list" in {
    dList.insert(1)
    dList.insert(2)
    dList.insert(3)
    dList.insert(4)

    dList.elementAt(1) should be (Some(2))
    dList.elementAt(2) should be (Some(3))
    dList.removeAt(1)
    dList.elementAt(1) should be (Some(3))                  //element pushed backwards
    dList.elementAt(2) should be (Some(4))                  //element pushed backwards
  }

  it should "find elements" in{
    dList.insert(1)
    dList.insert(2)
    dList.insert(3)

    dList.find(1) should be (Some(0))
    dList.find(2) should be (Some(1))
    dList.find(3) should be(Some(2))
    dList.find(4) should be (None)
  }

  it should "count how many elements the list contains" in{
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
    dList.insert(1)
    dList.insert(2)
    dList.insert(3)
    dList.clear
    dList.size should be (0)
    dList.elementAt(0) should be (None)
  }

  it should "throw an exception when trying to remove from a empty list" in {
    intercept[NullPointerException] {
      dList.remove(1)
    }
  }

  it should "return false when trying to insert in a invalid position" in {
    dList.insertAt(-1,5) should be (false)
    dList.isEmpty should be (true)
    dList.size should be (0)
  }

}
