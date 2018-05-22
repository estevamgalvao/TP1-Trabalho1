//package immutable
//
//sealed trait Stack[+A]
//
//case object Nil extends Stack[Nothing]
////case class Stack[+A](elements : List[A]){
//case class Cons[+A](top: A, rest: Stack[A]) extends Stack[A]
//
//object Stack {
//    def isEmpty[A](stack: Stack[A]) : Boolean = stack match{
//        case Nil => true
//        case Cons(x, xs) => false
//    }
//
//    def peek[A](stack: Stack[A]): Option[A] = stack match{
//        case Nil => None
//        case Cons(x, xs) => Some(x)
//    }
//
//    def push[A](value: A, stack: Stack[A]): Stack[A]=
//        Cons(value, stack)
//
//    def pop[A](stack: Stack[A]): Stack[A]= stack match{
//        case Nil => Nil
//        case Cons(x, xs) => xs
//    }
//
//    def size[A](stack: Stack[A]): Int = stack match {
//     case Nil => 0
//     case Cons(x, xs) => 1 + size(xs)
//  }
//
//     def apply[A](values: A*): Stack[A] =
//        if(values.isEmpty) Nil
//     else Cons(values.head, apply(values.tail: _*))
//
//}