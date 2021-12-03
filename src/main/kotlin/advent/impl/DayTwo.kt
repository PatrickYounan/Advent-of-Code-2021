package advent.impl

import advent.Day
import advent.data.DirectionParser
import advent.readLines
import java.nio.file.Paths

/**
 * @author Patrick
 */
class DayTwo : Day {

    override fun solve() {
        val inputs = readLines(Paths.get("data/daytwo.txt"), DirectionParser())

        var horizontal = 0
        var depth = 0
        for (direction in inputs) {
            when (direction.direction) {
                "forward" -> horizontal += direction.amount
                "down" -> depth += direction.amount
                "up" -> depth -= direction.amount
            }
        }

        println(horizontal * depth)

        horizontal = 0
        depth = 0

        var aim = 0
        for (direction in inputs) {
            when (direction.direction) {
                "down" -> aim += direction.amount
                "up" -> aim -= direction.amount
                "forward" -> {
                    horizontal += direction.amount
                    depth += (aim * direction.amount)
                }
            }
        }

        println(horizontal * depth)
    }

}