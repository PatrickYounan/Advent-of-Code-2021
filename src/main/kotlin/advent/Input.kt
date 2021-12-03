package advent

import java.nio.file.Files
import java.nio.file.Path

/**
 * @author Patrick
 */
object Input {

    fun read(path: Path): MutableList<Int> {
        val lines = Files.readAllLines(path)
        val inputs = mutableListOf<Int>()
        lines.forEach { inputs += it.toInt() }
        return inputs
    }

}