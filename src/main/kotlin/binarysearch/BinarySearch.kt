package com.jeishiva.binary_search

fun binarySearch(sortedInput: IntArray, search: Int): Int {
    var left = 0
    var right = sortedInput.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (sortedInput[mid] == search) {
            return mid
        } else if (sortedInput[mid] > search) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return -1
}

fun binarySearch(sortedInput: IntArray, search: Int, left: Int, right: Int): Int {
    var low = left
    var high = right
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (sortedInput[mid] == search) {
            return mid
        } else if (sortedInput[mid] > search) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
}



























