package model

import scala.collection.mutable

case class Edge(a: Int, b: Int) {}

/**
  * Created by salim on 9/10/2016.
  */
trait Graph[T <: Containable] extends Container[T] {
  private val edges = new mutable.HashSet[Edge]()

  def addEdge(a: T, b: T): Edge = addEdge(Edge(a.sn, b.sn))

  def addEdge(edge: Edge) = {
    edges.add(edge)
    edge
  }

  def incidentEdges(node: T): Set[Edge] = {
    incidentEdges(node.sn)
  }

  def incidentEdges(sn: Int): Set[Edge] = {
    edges.filter((e: Edge) => e.a == sn || e.b == sn).toSet
  }


}
