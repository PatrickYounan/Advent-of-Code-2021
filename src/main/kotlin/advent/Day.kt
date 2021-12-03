package advent

import java.nio.file.Files
import java.nio.file.Path

/**
 * @author Patrick Younan
 */
interface Day {
    fun solve()
}

fun solve(day: Day) {
    val start = System.currentTimeMillis()
    day.solve()
    val elapsed = System.currentTimeMillis() - start
    println("Solution took $elapsed ms.")
}

fun readIntList(path: Path): MutableList<Int> {
    val lines = Files.readAllLines(path)
    val inputs = mutableListOf<Int>()
    lines.forEach { inputs += it.toInt() }
    return inputs
}

fun <T> readLines(path: Path, result: Result<T>): MutableList<T> {
    val lines = Files.readAllLines(path)
    val elements = mutableListOf<T>()
    for (line in lines) {
        val element = result.parse(line) ?: continue
        elements += element
    }
    return elements
}