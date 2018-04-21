package ed_mutaveis
import org.scalatest._

class testLinkedList extends FlatSpec with Matchers {
  var lt = new linkedList[Int]
  it should "have size = 0 before stacking any element" in {
    lt.size shouldEqual 0
  }
}
