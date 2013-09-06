package tree

import scala.annotation.tailrec

object TernaryTreeOperations {
  def insert(tree: TernaryTree, node: Node): TernaryTree = {
    tree match {
      case EmptyNode => node
      case Node(value, left, middle, right) if value == node.value => Node(value, left, insert(middle, node), right)
      case Node(value, left, middle, right) if value < node.value  => Node(value, insert(left, node), middle, right)
      case Node(value, left, middle, right) if value > node.value  => Node(value, left, middle, insert(right, node))
    }
  }

  def size(tree: TernaryTree): Int = {
    tree match {
      case EmptyNode => 0
      case Node(value, left, middle, right) => 1 + size(left) + size(middle) + size(right)
    }
  }
  
  def toStream(tree: TernaryTree, stream: Stream[Int] = Stream.empty) : Stream[Int] = {
    tree match {
      case EmptyNode => Stream.empty
      case Node(value, left, middle, right) =>  value #:: toStream(middle, stream) ++ toStream(left, stream) ++ toStream(right, stream) ++ stream
    }
  }
}