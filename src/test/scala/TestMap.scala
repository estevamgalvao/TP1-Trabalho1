package ed_mutaveis

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestMap extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Map"
  var map : Map[Int, Char] = new MapImpl[Int, Char]()


  it should "have size == 0 before setting anything" in {
    map.size() should be (0)
  }

  it should "have size == 1 after setting (1, 'A')" in {
    map.set(1,'A')
    map.size() should be (1)
  }

   it should "return the value Some('A') after calling get(1)" in {
    map.get(1) should be (Some('A'))
  }

    it should "still have size == 1 after setting another value with the same key" in {
    map.set(1, 'B')
    map.size() should be (1)
  }

  it should "have size == 2 after adding another element (2, 'Z')" in {
      map.set(2, 'Z')
      map.get(2) should be (Some('Z'))
      map.size() should be (2)
  }



  it should "return the new value Some('B') after calling get(1)" in {
    map.get(1) should be (Some('B'))
    }

  it should "have size == 1 after removing key 1" in {
    map.remove(1)
    map.size() should be (1)
  }
   it should "have size == 0 after removing key 2" in {
    map.remove(2)
    map.size() should be (0)
  }





}