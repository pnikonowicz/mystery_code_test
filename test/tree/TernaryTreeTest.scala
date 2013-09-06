package tree

import org.scalatest.FlatSpec

class TernaryTreeTest extends FlatSpec {
  "add" should "add a node" in {
    val node_1 = Node(1)
    val node_2 = Node(2)
    val node_3 = Node(3)
    val node_4 = Node(4)
    val node_5 = Node(5)
    val treeList = List(node_1, node_2, node_3, node_3, node_4, node_5, node_5)
    val tree = treeList.foldLeft[TernaryTree](EmptyNode)(TernaryTreeOperations.insert)
    
    expect(treeList.size) {
      TernaryTreeOperations.size(tree)
    }
    
    expect("1,2,3,3,4,5,5") {
      TernaryTreeOperations.toStream(tree).mkString(",")
    }
  }
}