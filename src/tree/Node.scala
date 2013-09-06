package tree

object EmptyNode extends TernaryTree
case class Node(value: Int, left: TernaryTree = EmptyNode, middle: TernaryTree = EmptyNode, right: TernaryTree = EmptyNode) extends TernaryTree 

