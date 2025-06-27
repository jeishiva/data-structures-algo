package com.jeishiva

import com.jeishiva.binary_search.binarySearch
import com.jeishiva.binary_search.lowerBound
import com.jeishiva.binary_search.upperBound


fun main() {
    val input = intArrayOf(3,6,6,6,6,6)
    val result = binarySearch(
        input,
        6
    )
    println("result ${lowerBound(input, 6)}")
    println("result ${upperBound(input, 6)}")

}


