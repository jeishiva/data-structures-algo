package com.jeishiva.heap

class MinHeap(private val initialCapacity: Int = 5) : IHeap {
    private var size: Int = 0
    private var capacity = initialCapacity
    private var nodes = IntArray(capacity)

    private fun getParentIndex(childIndex: Int) = (childIndex - 1) / 2
    private fun getLeftChildIndex(parentIndex: Int) = (2 * parentIndex) + 1
    private fun getRightChildIndex(parentIndex: Int) = (2 * parentIndex) + 2

    private fun hasParent(childIndex: Int) = getParentIndex(childIndex) >= 0
    private fun hasLeftChild(parentIndex: Int) = getLeftChildIndex(parentIndex) < size
    private fun hasRightChild(parentIndex: Int) = getRightChildIndex(parentIndex) < size

    override fun insert(node: Int) {
        checkCapacity()
        nodes[size] = node
        size++
        heapifyUp()
    }

    private fun checkCapacity() {
        if (size < capacity) {
            return
        }
        println("increasing the nodes capacity as capacity is full")
        val nodesNew = IntArray(capacity * 2)
        nodes.copyInto(nodesNew)
        capacity *= 2
        nodes = nodesNew
    }

    private fun swap(firstIndex: Int, secondIndex: Int): Boolean {
        if (firstIndex == secondIndex) {
            return false
        }
        val temp = nodes[firstIndex]
        nodes[firstIndex] = nodes[secondIndex]
        nodes[secondIndex] = temp
        return true
    }

    override fun peek(): Int {
        checkHeapState()
        return nodes.first()
    }

    override fun poll(): Int {
        checkHeapState()
        val result = nodes[0]
        nodes[0] = nodes[size - 1]
        size--
        heapifyDown()
        return result
    }

    private fun checkHeapState() {
        if (isEmpty()) {
            throw IllegalStateException("heap is empty")
        }
    }

    override fun heapifyUp() {
        var currentNodeIndex = size - 1
        while (hasParent(currentNodeIndex) && nodes[currentNodeIndex] < nodes[getParentIndex(currentNodeIndex)]) {
            swap(currentNodeIndex, getParentIndex(currentNodeIndex))
            currentNodeIndex = getParentIndex(currentNodeIndex)
        }
    }


    override fun heapifyDown() {
        var parentIndex = 0
        while (hasLeftChild(parentIndex)) {
            val leftIndex = getLeftChildIndex(parentIndex)
            val rightIndex = getRightChildIndex(parentIndex)
            var minIndex = leftIndex
            if (hasRightChild(parentIndex) && nodes[rightIndex] < nodes[minIndex]) {
                minIndex = rightIndex
            }
            if (nodes[parentIndex] <= nodes[minIndex]) {
                break
            }
            swap(parentIndex, minIndex)
            parentIndex = minIndex
        }
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun clear() {
        size = 0
        nodes = IntArray(initialCapacity)
    }
}

