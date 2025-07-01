package com.jeishiva.sorting

import com.jeishiva.utils.swap


fun quickSort(input: IntArray, start: Int, end: Int) {
    val middle = start + (end - start) / 2
    val partition = sortPartition(input, 0, end, pivot = input[middle])
    quickSort(input, start, partition - 1)
    quickSort(input, partition, end)
}

fun sortPartition(input: IntArray, start: Int, end: Int, pivot: Int): Int {
    var left = start
    var right = end
    while (left <= right) {
        while (left <= right && input[left] < pivot) {
            left++
        }
        while (left <= right && input[right] > pivot) {
            right--
        }
        if (left <= right) {
            input.swap(left, right)
            left++
            right--
        }
    }
    return left
}

