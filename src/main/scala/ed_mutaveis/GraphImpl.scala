package br.unb.cic.ed.mutable

case class Vertice[T](val value: T, var next: Aresta[T] = null) //o next de um vertice aponta pra "primeira" aresta
case class Aresta[T](val value: T, val peso: T, var next: Aresta[T] = null) //o next de uma aresta aponta pro proximo na lista de adjacencia


class GraphImpl[T]() extends Graph[T] {
    private var vertices = new br.unb.cic.ed.mutable.doublyLinkedList[Vertice[T]]()

    private var _size = 0

    def insereAresta(vertice: Vertice[T], aresta: Aresta[T]) : Unit = {
        aresta.next = vertice.next
        vertice.next = aresta
    }
    
    def findByValue(value: T) : Option[Vertice[T]] = {
        if(vertices.isEmpty == false){
            var verticeAtual = vertices.nodePointer(0)
            for(i <- 0 until vertices.size){
                verticeAtual = vertices.nodePointer(i)
                if(verticeAtual.value.value == value)
                    return Some(verticeAtual.value)
            }
        }
        return None
    }

    def createLink(origin: T, destiny: T, weight: T, directed: Boolean): Unit = {
        val verticeExistente = findByValue(origin)
        var novoVertice = new Vertice[T](origin)
        verticeExistente match {
           case Some(v) =>  {
                            novoVertice = v}
           case None => {novoVertice = new Vertice[T](origin)
                     vertices.insert(novoVertice)
                    _size += 1}
        }

        var novaAresta = new Aresta[T](destiny, weight)
        insereAresta(novoVertice, novaAresta)

        if(directed == false)
            createLink(destiny, origin, weight, true)
    }

    def printGraph(): Unit = {
        println("vertices: ")
        var verticesIt = new br.unb.cic.ed.mutable.doublylistIterator[Vertice[T]](vertices)
        verticesIt.moveBegin
        for(i <- 0 until vertices.size ){
            print(verticesIt.current.value)
            print(" ")
            verticesIt.moveNext
        }
        println()
        println("arestas:")
        verticesIt.moveBegin
        for(i <- 0 until vertices.size ){
            var arestaAtual = verticesIt.current.next
            while(arestaAtual != null){
                print(verticesIt.current.value)
                print("->")
                print(arestaAtual.value)
                print(" ")

                arestaAtual = arestaAtual.next
            }
            verticesIt.moveNext
            print("\n")
        }
    }

    //retorna um map com todos os valores do grafo associados com false
    def InicializarMap() : Map[T, Boolean] = {
        var visited = new MapImpl[T, Boolean]
        var verticesIt = new br.unb.cic.ed.mutable.doublylistIterator[Vertice[T]](vertices)
        verticesIt.moveBegin
        for(i <- 0 until vertices.size ){
            visited.set(verticesIt.current.value, false)
            var arestaAtual = verticesIt.current.next
            while(arestaAtual != null){
                visited.set(arestaAtual.value, false)
                arestaAtual = arestaAtual.next
            }
            verticesIt.moveNext
        }
        return visited
    } 

    // tendo um problema com implementação do DFS usando array, elementos nem sempre serao int (tipo T)
    def DFSrecursao(vertice:T, visited: Map[T, Boolean], enablePrint : Boolean){
        visited.set(vertice, true)
        if(enablePrint) println(vertice)
        var verticeAtual : Vertice[T] = findByValue(vertice) match{
            case Some(v) => v
            case None => return
        }
        var arestaAtual = verticeAtual.next
        do{
            visited.get(arestaAtual.value) match {
               case Some(v) => {if(v==false) DFSrecursao(arestaAtual.value, visited, enablePrint)}
               case  None => 
            }
            arestaAtual = arestaAtual.next
        }while(arestaAtual != null)
    }

    def DFS(vertice: T, enablePrint : Boolean){
        var visited = InicializarMap()
        DFSrecursao(vertice, visited, enablePrint)
    }

    def BFS(vertice: T, enablePrint: Boolean)
    {
        var visited = InicializarMap()
        var filaNos = new Queue[T]

        visited.set(vertice, true)
        filaNos.insert(vertice)
        
        while(filaNos.isEmpty == false){
            var verticeAtual : T = vertice
            filaNos.first match {
                case Some(v) => verticeAtual = v
                case None => 
            }
            filaNos.remove

            if(enablePrint) println(verticeAtual)

            var arestaAtual : Aresta[T] = null
            findByValue(verticeAtual) match {
                case Some(v) => arestaAtual = v.next
                case None => arestaAtual = null
            }
            while(arestaAtual != null){
                if(visited.get(arestaAtual.value) == Some(false)){
                    visited.set(arestaAtual.value, true)
                    filaNos.insert(arestaAtual.value)
                }
                arestaAtual = arestaAtual.next
            }
        }
        
    }


    def size(): Int = _size //numero de vertices
}