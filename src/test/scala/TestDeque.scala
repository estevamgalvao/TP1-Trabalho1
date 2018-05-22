package ed_mutaveis

//import org.scalatest.FlatSpec
//import org.scalatest.Matchers
//import org.scalatest.GivenWhenThen
//import org.scalatest.BeforeAndAfter
import org.scalatest._

class TestDeque extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Deque"

  var deque : Deque[Int] = _

  before{
    deque = new DequeImpl[Int]()
  }



  it should "have size == 0 before enqueueing any element" in {
    deque.size() should be (0)
  }

  it should "have size == 3 after enqueueing 3 elements" in {
    deque.size() should be (0)

    deque.enqueueFront(3)
    deque.enqueueBack(2)
    deque.enqueueFront(1)

    deque.size() should be (3)
  }

  it should "return Some(30) after front-enqueueing the following elements: 30,20,10; and back-dequeueing once" in {
    deque.size() should be (0)

    deque.enqueueFront(30)
    deque.enqueueFront(20)
    deque.enqueueFront(10)

    deque.size() should be (3)

    deque.dequeueBack() should be (Some(30))

    deque.size() should be (2)

    deque.dequeueFront() should be (Some(10))
    deque.dequeueBack() should be (Some(20))

    deque.size() should be (0)
  }


  it should "should return None when we call dequeueFront() or dequeueBack() on an empty queue" in {
    deque.dequeueFront() should be (None)
    deque.dequeueBack() should be (None)
  }

  it should "should return Some(10) after back-enqueueing the following element: 10, 20, 30; and front-dequeueing once" in {
    deque.size() should be (0)

    deque.enqueueBack(10)
    deque.enqueueBack(20)
    deque.enqueueBack(30)

    deque.size() should be (3)

    deque.dequeueFront() should be (Some(10))

    deque.dequeueBack() should be (Some(30))

  }


}
