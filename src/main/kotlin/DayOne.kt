package com.the_mgi

import java.io.File
import kotlin.math.abs

fun readFile(): Pair<List<Int>, List<Int>> {
    val first = mutableListOf<Int>()
    val second = mutableListOf<Int>()

    File("src/main/resources/day_1/input.txt")
        .readLines()
        .forEach {
            val (firstElement, secondElement) = it.split("   ")
            first.add(firstElement.toInt())
            second.add(secondElement.toInt())
        }

    return Pair(first.sorted(), second.sorted())
}

fun sumOfDifferences(): Int {
    val (first, second) = readFile()
    return first.mapIndexed { index, i -> abs((i - second[index])) }.sum()
}

fun similarityScore(): Int {
    val (first, second) = readFile()
    val map = second.groupBy { it }
    return first.sumOf { if (it in map) it * map[it]!!.size else 0 }
}