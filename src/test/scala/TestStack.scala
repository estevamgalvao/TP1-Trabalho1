package immutable

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestImmutableStack extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {
  behavior of "An immutable stack"

  it should "return 5 when we call Stack.size(s1) and s1 =  Stack(1,2,3,4,5)" in {
    val s1 = Stack(1, 2, 3, 4, 5)
    Stack.size(s1) should be (5)
  }

  it should "return 0 when we call List.size(l1) and s1 = Nil" in {
    val s1 = Nil
    Stack.size(s1) should be (0)
  }

  it should "return true when we call Stack.isEmpty(s1) and s1 = Nil" in {
    val s1 = Nil
    Stack.isEmpty(s1) should be (true)
  }

  it should "return Some(10) after calling Stack.peek(s1) in s1 = Stack(10, 20, 30)" in {
    val s1 = Stack(10,20,30)

    Stack.size(s1) should be (3)

    Stack.peek(s1) should be (Some(10))
    val s2 = Stack.pop(s1)

    Stack.size(s2) should be (2)

    Stack.peek(s2) should be (Some(20))
  }

  it should "return Stack(20,10) when we call Stack.pop(s1) and s1 = Stack(30,20,10)" in{
    val s1 = Stack(30, 20, 10)
    Stack.pop(s1) should be (Stack(20, 10))
  }

  it should "should return Nil when we call Stack.pop(s1) and s1 = Nil" in {
    val s1 = Nil
    Stack.pop(s1) should be (Nil)
  }


}
