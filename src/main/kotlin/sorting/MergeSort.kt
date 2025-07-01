package com.jeishiva.sorting

fun mergeSort(input: IntArray) {
    mergeSort(input,
        0,
        input.size - 1,
        result = IntArray( input.size) { -1 })
}

fun mergeSort(input: IntArray, start: Int, end: Int, result: IntArray) {
    if (start >= end) {
        return
    }
    val middle = start + (end - start) / 2
    mergeSort(input, start, middle, result)
    mergeSort(input, middle + 1, end, result)
    mergePartition(input, start, end, middle, result)
}

fun mergePartition(
    input: IntArray,
    start: Int,
    end: Int,
    middle: Int,
    result: IntArray
) {
    var leftStart = start
    var rightStart = middle + 1
    var index = leftStart
    while (leftStart <= middle && rightStart <= end) {
        if (input[leftStart] < input[rightStart]) {
            result[index] = input[leftStart]
            leftStart++
        } else {
            result[index] = input[rightStart]
            rightStart++
        }
        index++
    }
    while (leftStart <= middle) {
        result[index] = input[leftStart]
        leftStart++
        index++
    }
    while (rightStart <= end) {
        result[index] = input[rightStart]
        rightStart++
        index++
    }
    var current = start
    while (current <= end) {
       input[current] = result[current]
       current++
    }
}