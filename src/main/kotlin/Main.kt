package com.jeishiva

import com.jeishiva.binarytree.BSTIterative
import com.jeishiva.binarytree.BTNode
import com.jeishiva.binarytree.BTTraversalType

fun main() {

    val tree = BSTIterative<Int>()
    tree.insert(node = BTNode(50))
    tree.insert(node = BTNode(30))
    tree.insert(node = BTNode(70))
    tree.insert(node = BTNode(20))
    tree.insert(node = BTNode(40))
    tree.insert(node = BTNode(60))
    tree.insert(node = BTNode(10))
    val list = tree.traverse(BTTraversalType.InOrder)
    list.forEach {
        println(it)
    }
}

