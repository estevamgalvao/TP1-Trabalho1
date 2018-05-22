package ed_mutaveis

trait Map[A,B] {
  def get(key: A) : Option[B]
  def set(key: A, value: B): Unit
  def remove(key: A) : Unit
  def size() : Int
}