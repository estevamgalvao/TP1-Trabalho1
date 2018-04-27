package ed_mutaveis

trait traitListIterator[T] {
//  def assign (list : traitList[T]) : Unit
  def lastVisited: T
  def next: Option[T]
  def prev: Option[T]
  def begin: T
  def end: T
  def current: T
  def moveLastVisited: Unit
  def moveNext: Unit
  def movePrev: Unit
  def moveBegin: Unit
  def moveEnd: Unit
}
