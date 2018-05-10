package ed_mutaveis
import org.scalatest._

class hashTableSpec extends FlatSpec with Matchers {
  behavior of "A Hash Table"

  def func (x: Int) :Int = {
    (x*10)-10
  }

  def brokenFunction (x: Int) : Int = {
    (x*2)
  }

  it should "create key value pairs correctly" in {


    val hTable = new hashTable[Int](100, func)
    hTable.insert(1)
    hTable.insert(2)
    hTable.insert(3)

    hTable.check(1) should be (Some(0))
    hTable.check(2) should be (Some(10))
    hTable.check(3) should be (Some(20))


  }

  it should "return None when trying to check a non existing element" in {
    val hTable = new hashTable[Int](100, func)
    hTable.insert(1)
    hTable.insert(2)
    hTable.insert(3)

    hTable.check(4) should be (None)
  }

  it should "not allow the insertion of elements that go beyond the key array size" in {
    val hTable = new hashTable[Int](5, brokenFunction)
    intercept[ArrayIndexOutOfBoundsException] {
      hTable.insert(3)
    }
  }
}
