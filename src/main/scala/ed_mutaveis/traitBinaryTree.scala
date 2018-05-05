package ed_mutaveis

trait traitBinaryTree[T] {
  def insert(value: T): Unit
  def remove(value: T): Unit
  def updateHead(value: T): Unit
  def size: Int
  def show: Unit


/*fazer função show recusiva, lendo todos os nós da direita
então quando eu passar para outro nó chamar a função novamente
e andar entre os nós esquerda e direita
 */


}
