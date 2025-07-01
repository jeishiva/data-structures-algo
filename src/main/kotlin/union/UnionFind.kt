package com.jeishiva.union

class UnionFind(private val nodes: IntArray) {
    private val parentMap: MutableMap<Int, Int> = mutableMapOf()
    private val rankMap: MutableMap<Int, Int> = mutableMapOf()
    private var distinctNodes = nodes.size

    init {
        for (node in nodes) {
            parentMap[node] = node
            rankMap[node] = 0
        }
    }

    private fun findParent(node: Int): Int {
        if (node != parentMap[node]) {
            parentMap[node] = findParent(parentMap[node]!!)
        }
        return parentMap[node]!!
    }

    fun union(connection: Pair<Int, Int>) {
        val parent1 = findParent(connection.first)
        val parent2 = findParent(connection.second)
        if (parent1 == parent2) {
            return
        }
        if (rankMap[parent1]!! > rankMap[parent2]!!) {
            parentMap[parent2] = parent1
        } else if (rankMap[parent1]!! < rankMap[parent2]!!) {
            parentMap[parent1] = parent2
        } else {
            parentMap[parent1] = parent2
            rankMap[parent1] = rankMap[parent1]!! + 1
        }
        distinctNodes--
    }

}