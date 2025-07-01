package com.jeishiva.heap

interface IHeap {
    fun insert(node : Int)
    fun peek() : Int
    fun poll() : Int
    fun heapifyUp()
    fun heapifyDown()
    fun isEmpty() : Boolean
    fun clear()
}