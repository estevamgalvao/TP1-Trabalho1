package br.unb.cic.ed.mutable

trait Graph[T] {
  def createLink(origin: T, destiny: T, weight: T, directed: Boolean): Unit
  def size(): Int
  def BFS(vertice: T, enablePrint: Boolean) : Unit
  def DFS(vertice: T, enablePrint: Boolean) : Unit
}