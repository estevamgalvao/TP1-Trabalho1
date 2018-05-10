package ed_mutaveis
import org.scalatest._

class binaryTreeSpec extends FlatSpec with Matchers with BeforeAndAfter {
  behavior of "A Binary Tree"

  var bTree : binaryTree[Int] = _

  before{
    bTree = new binaryTree[Int]
  }
  it should "insert elements properly" in {
    bTree.insert(5)
    bTree.insert(3)
    bTree.insert(7)

    bTree.size() should be (3)

    bTree.insert(2)

    bTree.size() should be (4)

    bTree.exist(5) should be (true)
    bTree.exist(2) should be (true)
  }

  it should "remove elements properly" in {
    bTree.insert(5)
    bTree.insert(3)
    bTree.insert(7)

    bTree.insert(2)
    bTree.insert(4)

    bTree.insert(6)
    bTree.insert(8)

    bTree.exist(8) should be (true)
    bTree.remove(8)                       //1 children element
    bTree.exist(8) should be (false)

    bTree.exist(5) should be (true)
    bTree.remove(5)                       //2 children element
    bTree.exist(5) should be(false)

    bTree.size() should be (5)
  }

  it should "give its size" in {
    bTree.insert(1)
    bTree.insert(2)
    bTree.insert(3)
    bTree.insert(4)

    bTree.size() should be (4)

    bTree.remove(2)

    bTree.size() should be (3)
  }

  it should "respond if a certain element exists" in {
    bTree.insert(2)
    bTree.insert(1)
    bTree.insert(3)

    bTree.exist (2) should be (true)
    bTree.exist(1) should be (true)
    bTree.exist (3) should be (true)
  }

  it should "respond if a certain element does not exist" in {
    bTree.insert(2)
    bTree.insert(1)
    bTree.insert(3)

    bTree.exist(4) should be (false)
    bTree.exist(5) should be (false)
  }
  it should "not insert an element that already exists" in {
    bTree.insert(2)
    bTree.insert(1)
    bTree.insert(3)

    bTree.insert(3)

    bTree.size() should be (3)
  }

  it should "not remove if it's empty" in {
    intercept[NullPointerException]{
      bTree.remove(3)
    }
  }


}
