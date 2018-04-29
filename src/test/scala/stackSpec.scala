package ed_mutaveis
import org.scalatest._

class stackSpec extends FlatSpec with Matchers {                                  //TO DO: test specific structures aspects, such as, LIFO
  behavior of "A Stack"

  it should "have size = 0 / empty, before stacking any element" in {
    val st = new Stack[Int]
    st.size should be (0)
    st.isEmpty should be (true)
  }

  it should "correspond the correct size value for insert and pop functions" in {
    val st = new Stack[Int]
    st.insert(1)
    st.insert(2)
    st.insert(3)
    st.pop
    st.pop
    st.size should be (1)
  }

  it should "find elements" in {
    val st = new Stack[Int]
    st.insert(1)
    st.insert(2)
    st.insert(3)

    st.find(2) should be (Some(1))
  }

  it should "count elements" in {
    val st = new Stack[Int]
    st.insert(1)
    st.insert(2)
    st.insert(2)
    st.insert(3)
    st.insert(2)

    st.count(2) should be (3)
    st.count(3) should be (1)
  }

  it should "clear it self" in {
    val st = new Stack[Int]
    st.insert(1)
    st.insert(2)
    st.insert(3)

    st.clear
    st.size should be (0)
    st.isEmpty should be (true)
  }

}
