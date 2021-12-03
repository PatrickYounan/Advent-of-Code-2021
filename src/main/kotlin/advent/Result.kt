package advent

/**
 * @author Patrick
 */
interface Result<T> {

    fun parse(line: String): T
}