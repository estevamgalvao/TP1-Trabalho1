package br.unb.cic.ed.mutable

class MapImpl[A, B]() extends Map[A, B] {

    private var keys = new br.unb.cic.ed.mutable.doublyLinkedList[A]()
    private var values = new br.unb.cic.ed.mutable.doublyLinkedList[B]()
    private var _size : Int = 0

    def get(key : A) : Option[B] = {
        keys.find(key) match {
            case Some(index) => values.elementAt(index)
            case None => None
        }
    }

    def set(key: A, value: B) : Unit = {
        keys.find(key) match {
            case Some(index) => values.modify(index, value)
            case None => {keys.insert(key)
                        values.insert(value)
                        _size += 1}
        }

    }

    def remove(key: A) : Unit = {
        keys.find(key) match {
            case Some(index) => {{keys.removeAt(index)
                        values.removeAt(index)
                        _size -= 1}}
            case None => None
        }
    }

    def size() : Int = _size


}