package com.jeishiva.binary_search


fun binarySearch(sortedInput: IntArray, search: Int): Boolean {
    var left = 0
    var right = sortedInput.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (sortedInput[mid] == search) {
            return true
        } else if (sortedInput[mid] > search) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return false
}


fun lowerBound(sortedInput: IntArray, search: Int): Int {
    var left = 0
    var right = sortedInput.size - 1
    var lowerBound = -1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (sortedInput[mid] == search) {
            lowerBound = mid
            right = mid - 1
        }
        else if (sortedInput[mid] >= search) {
            right = mid - 1
        } else  {
            left = mid + 1
        }
    }
    return lowerBound
}


fun upperBound(sortedInput: IntArray, search: Int): Int {
    var left = 0
    var right = sortedInput.size - 1
    var upperBound = -1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (sortedInput[mid] == search) {
            upperBound = mid
            left = mid + 1
        }
        else if (sortedInput[mid] >= search) {
            right = mid - 1
        } else  {
            left = mid + 1
        }
    }
    return upperBound
}
