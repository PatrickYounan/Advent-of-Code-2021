package advent.impl

import advent.Day
import advent.readList
import java.nio.file.Paths

/**
 * @author Patrick Younan
 */
class DayOne : Day {

    override fun solve() {
        val inputs = readList(Paths.get("data/dayone.txt"))

        println(getChanges(inputs))

        val windows = mutableListOf<Int>()
        for (i in 2 until inputs.size) {
            windows += inputs[i] + inputs[i - 1] + inputs[i - 2]
        }

        println(getChanges(windows))
    }

    private fun getChanges(values: List<Int>): Int {
        var count = 0
        for (i in 1 until values.size) {
            if (values[i - 1] < values[i]) count++
        }
        return count
    }

}