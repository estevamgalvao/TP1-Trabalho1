package ed_mutaveis
import org.scalatest._

class stackSpec extends FlatSpec with Matchers with BeforeAndAfter {
  behavior of "A Stack"

  var st : Stack[Int] = _

  before {
    st = new Stack[Int]
  }

  it should "have size = 0 / empty, before stacking any element" in {
    st.size should be (0)
    st.isEmpty should be (true)
  }

  it should "correspond the correct size value for insert and pop functions" in {
    st.insert(1)
    st.insert(2)
    st.insert(3)
    st.pop
    st.pop
    st.size should be (1)
  }

  it should "find elements" in {
    st.insert(1)
    st.insert(2)
    st.insert(3)

    st.find(2) should be (Some(1))
  }

  it should "count elements" in {
    st.insert(1)
    st.insert(2)
    st.insert(2)
    st.insert(3)
    st.insert(2)

    st.count(2) should be (3)
    st.count(3) should be (1)
  }

  it should "clear it self" in {
    st.insert(1)
    st.insert(2)
    st.insert(3)

    st.clear
    st.size should be (0)
    st.isEmpty should be (true)
  }

  it should "Respect the LIFO order" in{
     st.insert(1)
    st.insert(2)
    st.insert(3)
    st.insert(4)

    st.find(4) should be (Some(3))
    st.pop
    st.find(4) should be (None)

    st.find(3) should be (Some(2))
    st.pop
    st.find(3) should be (None)
  }

}
