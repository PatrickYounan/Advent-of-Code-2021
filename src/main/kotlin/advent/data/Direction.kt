package advent.data

import advent.Result

/**
 * @author Patrick
 */
data class Direction(val direction: String, val amount: Int)

class DirectionParser : Result<Direction> {

    override fun parse(line: String): Direction {
        val args = line.split(" ")
        val way = args[0]
        val amount = args[1].toInt()
        return Direction(way, amount)
    }

}