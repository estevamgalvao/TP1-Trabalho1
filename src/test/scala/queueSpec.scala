package ed_mutaveis
import org.scalatest._

class queueSpec extends FlatSpec with Matchers with BeforeAndAfter {
  behavior of "A Queue"

  var qe : Queue[Int] = _

  before{
    qe = new Queue[Int]
  }

  it should "have size = 0 / empty, before queueing any element" in {
    qe.size should be (0)
    qe.isEmpty should be (true)
  }

  it should "correspond the correct size value for insert and pop functions" in {
    qe.insert(1)
    qe.insert(2)
    qe.insert(3)
    qe.remove
    qe.remove
    qe.size should be (1)
  }

  it should "find elements" in {
    qe.insert(1)
    qe.insert(2)
    qe.insert(3)

    qe.find(2) should be (Some(1))
  }

  it should "count elements" in {
    qe.insert(1)
    qe.insert(2)
    qe.insert(2)
    qe.insert(3)
    qe.insert(2)

    qe.count(2) should be (3)
    qe.count(3) should be (1)
  }

  it should "clear it self" in {
    qe.insert(1)
    qe.insert(2)
    qe.insert(3)

    qe.clear
    qe.size should be (0)
    qe.isEmpty should be (true)
  }

  it should "Respect the FIFO order" in {
    qe.insert(1)
    qe.insert(2)
    qe.insert(3)
    qe.insert(4)

    qe.first should be(Some(1))
    qe.remove
    qe.first should be (Some(2))

    qe.insert(5)                                         // this should't affect the first element, since it's being inserted in the end of the queue
    qe.first should be (Some(2))

  }

}
