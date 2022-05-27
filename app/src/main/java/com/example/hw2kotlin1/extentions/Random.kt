package com.example.hw2kotlin1.extentions

import kotlin.random.Random

fun <T> Collection<T>.randomList(): T {
    return randomRet(Random)
}

fun <T> Collection<T>.randomRet(random: Random): T {
    if (isEmpty())
        throw NoSuchElementException("Collection is empty.")
    return elementAtMore(random.nextInt(size))
}

fun <T> Iterable<T>.elementAtMore(index: Int): T {
    if (this is List)
        return get(index)
    return elementAtOrElseMore(index) { throw IndexOutOfBoundsException("Collection doesn't contain element at index $index.") }
}

fun <T> List<T>.getOrElseMore(index: Int, defaultValue: (Int) -> T): T {
    return if (index in 0..lastIndex) get(index) else defaultValue(index)
}

fun <T> Iterable<T>.elementAtOrElseMore(index: Int, defaultValue: (Int) -> T): T {
    if (this is List)
        return this.getOrElseMore(index, defaultValue)
    if (index < 0)
        return defaultValue(index)
    val iterator = iterator()
    var count = 0
    while (iterator.hasNext()) {
        val element = iterator.next()
        if (index == count++)
            return element
    }
    return defaultValue(index)
}