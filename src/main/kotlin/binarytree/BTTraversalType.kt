package com.jeishiva.binarytree

sealed class BTTraversalType {
    data object PreOrder : BTTraversalType()
    data object PostOrder : BTTraversalType()
    data object InOrder : BTTraversalType()
}