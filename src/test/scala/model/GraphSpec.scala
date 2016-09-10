package model

import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

import scala.collection.immutable.HashSet

/**
  * Created by salim on 9/9/2016.
  */
class GraphSpec extends FlatSpec with Matchers with BeforeAndAfterEach {

  var w: World = null


  override def beforeEach(): Unit = {
    super.beforeEach()
    w = World.factory()
  }

  "Nodes" can "be joined together to make edges" in {
    val r0 = w.newRoom
    val r1 = w.newRoom
    val e = w.addEdge(r0, r1)
  }

  they can "initially have no incident edges" in {
    val r0 = w.newRoom
    assert(w.incidentEdges(r0) == HashSet())
  }

  they can "have multiple incident edges" in {
    val r0 = w.newRoom
    val r1 = w.newRoom
    val r2 = w.newRoom

    val e0 = w.addEdge(r0, r1)
    val e1 = w.addEdge(r0, r2)

    assert(w.incidentEdges(r0) == HashSet(Edge(r0.sn, r1.sn), Edge(r0.sn, r2.sn)))
  }

  they can "be requested from their destination as well as the source" in {
    val r0 = w.newRoom
    val r1 = w.newRoom
    val r2 = w.newRoom

    val e0 = w.addEdge(r1, r0)
    val e1 = w.addEdge(r1, r0)

    assert(w.incidentEdges(r0) == HashSet(Edge(r1.sn, r0.sn), Edge(r1.sn, r0.sn)))
  }

  "Edges" can "be automatically deleted when nodes are deleted" in {
    val r0 = w.newRoom
    val r1 = w.newRoom
    val r2 = w.newRoom

    val e0 = w.addEdge(r0, r1)
    val e1 = w.addEdge(r0, r2)

    w.remove(r0.sn)

    assert(w.incidentEdges(r1) == Set())
    assert(w.incidentEdges(r2) == Set())
  }

}
