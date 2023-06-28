package com.tree

import scala.collection.mutable._

class Treenode(nodedata: Int) {
  var data = nodedata
  var left: Treenode = null
  var right: Treenode = null
}

class BinarySearchTree {
  var root: Treenode = _

  def insert(data: Int): Treenode = {
    root = insert(data, root)
    root
  }

  def insert(data: Int, rt: Treenode): Treenode = {
    if (rt == null) {
      root = new Treenode(data)
      return root
    }
    if (data < rt.data)
      rt.left = insert(data, rt.left)
    else
      rt.right = insert(data, rt.right)
    rt
  }

  def inOrder(root: Treenode): Unit = {
    if (root == null)
      return
    inOrder(root.left)
    print(root.data + " ")
    inOrder(root.right)
  }
}

class BinaryTree {
  var root: Treenode = null

  def createBinaryTree() = {
    val first = new Treenode(9)
    val second = new Treenode(2)
    val third = new Treenode(3)
    val fourth = new Treenode(4)
    first.left = second
    first.right = third
    second.left = fourth
    root = first
  }

  def preOrder(root: Treenode): Unit = {
    if (root == null)
      return
    print(root.data + " ")
    preOrder(root.left)
    preOrder(root.right)
  }

  def iterativePreOrder(): Unit = {
    if (root == null)
      return
    val stack: Stack[Treenode] = Stack()
    stack.push(root)
    while (!stack.isEmpty) {
      val temp = stack.pop()
      print(temp.data + " ")
      if (temp.right != null)
        stack.push(temp.right)
      if (temp.left != null)
        stack.push(temp.left)
    }
  }

  def inOrder(root: Treenode): Unit = {
    if (root == null)
      return
    inOrder(root.left)
    print(root.data + " ")
    inOrder(root.right)
  }

  def iterativeInOrder(): Unit = {
    if (root == null)
      return
    val stack: Stack[Treenode] = Stack()
    var temp = root
    while (!stack.isEmpty || temp != null) {
      if (temp != null) {
        stack.push(temp)
        temp = temp.left
      }
      else {
        temp = stack.pop()
        print(temp.data + " ")
        temp = temp.right
      }
    }
  }

  def postOrder(root: Treenode): Unit = {
    if (root == null)
      return
    postOrder(root.left)
    postOrder(root.right)
    print(root.data + " ")
  }

  def iterativePostOrder(): Unit = {
    if (root == null)
      return
    val stack: Stack[Treenode] = Stack()
    var current = root
    while (!stack.isEmpty || current != null) {
      if (current != null) {
        stack.push(current)
        current = current.left
      }
      else {
        var temp = stack.top.right
        if (temp == null) {
          temp = stack.pop()
          print(temp.data + " ")
          while (!stack.isEmpty && temp == stack.top.right) {
            temp = stack.pop()
            print(temp.data + " ")
          }
        }
        else {
          current = temp
        }
      }
    }
  }

  def levelOrder(): Unit = {
    if (root == null)
      return
    val queue: Queue[Treenode] = Queue()
    queue.enqueue(root)
    while (!queue.isEmpty) {
      val temp = queue.dequeue
      print(temp.data + " ")
      if (temp.left != null)
        queue.enqueue(temp.left)
      if (temp.right != null)
        queue.enqueue(temp.right)
    }
  }

  def findMax(root: Treenode): Int = {
    if (root == null) {
      return Integer.MIN_VALUE
    }
    var result = root.data
    val left = findMax(root.left)
    val right = findMax(root.right)
    if (result < left)
      result = left
    if (result < right)
      result = right
    result
  }

  def find(key: Int, root: Treenode): Treenode = {
    if (root.data == key || root == null)
      return root
    if (key < root.data)
      find(key, root.left)
    else
      find(key, root.right)
  }
}

object TreeMain extends App {
  val bst = new BinarySearchTree
  bst.insert(5)
  bst.insert(3)
  bst.insert(8)
  bst.insert(7)
  bst.insert(1)
  bst.insert(4)
  bst.insert(9)
  bst.inOrder(bst.root)
}
