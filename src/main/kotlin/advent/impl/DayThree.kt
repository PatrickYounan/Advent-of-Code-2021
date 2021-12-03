package advent.impl

import advent.Day
import java.nio.file.Files.readAllLines
import java.nio.file.Paths
import kotlin.math.pow


/**
 * @author Patrick
 */
class DayThree : Day {

    private val inputs = readAllLines(Paths.get("data/daythree.txt"))

    override fun solve() {
        solvePartOne()
        solvePartTwo()
    }

    private fun calculateArrays(inputs: List<String>): List<IntArray> {
        val ones = IntArray(inputs[0].length)
        val zeroes = IntArray(inputs[0].length)
        for (binary in inputs) {
            for (i in binary.indices) {
                if (binary[i] == '0')
                    zeroes[i]++
                else ones[i]++
            }
        }
        return listOf(ones, zeroes)
    }

    private fun solvePartOne() {
        val (ones, zeroes) = calculateArrays(inputs)
        var gamma = 0.0
        var epsilon = 0.0

        for (i in ones.indices) {
            val value = 2.0.pow(ones.size - (i + 1))
            if (ones[i] > zeroes[i])
                gamma += value
            else epsilon += value
        }
        println((gamma * epsilon).toInt())
    }

    private fun solvePartTwo() {
        val oxygenElements = mutableListOf<String>()
        val co2Elements = mutableListOf<String>()
        oxygenElements.addAll(inputs)
        co2Elements.addAll(inputs)

        var index = 0
        while (oxygenElements.size > 1) {
            val (ones, zeroes) = calculateArrays(oxygenElements)
            for (i in oxygenElements.indices.reversed()) {
                val element = oxygenElements[i][index]
                if (ones[index] >= zeroes[index] && element == '0' || ones[index] < zeroes[index] && element == '1')
                    oxygenElements.removeAt(i)
            }
            index++
        }

        index = 0
        while (co2Elements.size > 1) {
            val (ones, zeroes) = calculateArrays(co2Elements)
            for (i in co2Elements.indices.reversed()) {
                val element = co2Elements[i][index]
                if (ones[index] >= zeroes[index] && element == '1' || ones[index] < zeroes[index] && element == '0')
                    co2Elements.removeAt(i)
            }
            index++
        }
        println((oxygenElements[0].toInt(2) * co2Elements[0].toInt(2)))
    }

}