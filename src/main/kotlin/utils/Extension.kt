package com.jeishiva.utils



fun <T> Array<T>.swap(left : Int, right : Int) {
    if (left == right) {
        return
    }
    val temp = this[left]
    this[left] = this[right]
    this[right] = temp
}

fun IntArray.swap(left: Int, right: Int) {
    if (left == right) return
    val temp = this[left]
    this[left] = this[right]
    this[right] = temp
}